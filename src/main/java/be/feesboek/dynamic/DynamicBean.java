package be.feesboek.dynamic;

import be.feesboek.beans.ComplexVO;
import be.feesboek.dynamic.form.Column;
import be.feesboek.dynamic.form.Block;
import be.feesboek.dynamic.form.Field;
import be.feesboek.dynamic.FieldType;
import be.feesboek.gridform.MyPanelGroup;
import be.feesboek.gridform.MyPrimePanelGrid;
import be.feesboek.gridform.component.MyGridComplex;
import be.feesboek.gridform.component.MyGridDate;
import be.feesboek.gridform.component.MyGridInputText;
import be.feesboek.gridform.component.MyGridRadio;
import be.feesboek.gridform.component.MyGridSelectBooleanCheckbox;
import be.feesboek.gridform.element.MyPrimeOutputLabel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlPanelGroup;
import javax.inject.Named;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;

/**
 *
 * @author dimitridw
 */
@Named
@SessionScoped
public class DynamicBean implements Serializable {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DynamicBean.class);

    private static final long serialVersionUID = 1L;

    private DynamicFormVO dynamicFormVO;
    private DynamicModelVO dynamicModelVO;

    private transient HtmlPanelGroup formFromCode;

    @PostConstruct
    public void init() {

        // create dynamic form Model
        createDynamicFormModel();

        initDataModel();

        //create form, b
        formFromCode = MyPanelGroup.generateResponsive();
        //TODO run over FormModel and create all.

        LOGGER.debug("START");
        int i = 0;
        for (Block block : dynamicFormVO.getBlocks()) {
            PanelGrid gridBlock = MyPrimePanelGrid.generateResponsive(1);

            LOGGER.debug("-BLOCK = {}", i);

            String blockId = "block-id-" + i;
            OutputLabel labelBlock = MyPrimeOutputLabel.generateWithIdAndLabel(block.getName(), blockId);
            gridBlock.getChildren().add(labelBlock);

            // Create a grid to put all columns next to eachother.
            PanelGrid gridBlockColumns = MyPrimePanelGrid.generateResponsive(block.getColumns().size());

            int j = 0;
            for (Column column : block.getColumns()) {
                PanelGrid gridColumn = MyPrimePanelGrid.generateResponsive(1);
                LOGGER.debug("---COLUMN = {}-{}", i, j);

                String columnId = "column-id-" + i + "-" + j;
                OutputLabel labelColumn = MyPrimeOutputLabel.generateWithIdAndLabel(column.getName(), columnId);
                gridColumn.getChildren().add(labelColumn);

                int z = 0;
                for (Field field : column.getFields()) {
                    PanelGrid gridField = MyPrimePanelGrid.generateResponsive(1);

                    LOGGER.debug("-----FIELD = {}-{}-{} for type: {}", i, j, z, field.getType());
                    String fieldId = "field-id-" + i + "-" + j + "-" + z;
                    String elementId = "element-id-" + i + "-" + j + "-" + z;

                    //Not necessary to add label of the field above the field
//                    OutputLabel labelField = MyPrimeOutputLabel.generateWithIdAndLabel(field.getName(), fieldId);
//                    gridField.getChildren().add(labelField);
                    //TODO: wat met expression? hoort toch bij model?
                    //Waarom expression opbouwen bij form en doorverwijzen naar model?
                    //alhoewel: form hoort de expression te bevatten, want linkt met model.
                    //hoe oplossen met complexVO type? expression in 2 opdelen? of een composite maken?
                    ///hmm:misschien niet expression noemen, maar object waar naartoe.
                    // dan bij opbouwen object: als type = complex-> toevoegen.
                    String expression = "";
                    HtmlPanelGroup element;
                    switch (field.getType()) {
                        case TEXT:
                            expression = "#{dynamicBean.dynamicModelVO." + field.getModel() + "}";
                            element = MyGridInputText.generate(field.getName(), "text", elementId, expression);
                            break;
                        case CALENDAR:
                            expression = "#{dynamicBean.dynamicModelVO." + field.getModel() + "}";
                            element = MyGridDate.generate(field.getName(), elementId, expression);
                            break;
                        case RADIO:
                            expression = "#{dynamicBean.dynamicModelVO." + field.getModel() + "}";
                            element = MyGridRadio.generate(field.getName(), elementId, expression);
                            break;
                        case COMPLEX:
                            String expressionText = "#{dynamicBean.dynamicModelVO." + field.getModel() + ".text}";
                            String expressionDrop = "#{dynamicBean.dynamicModelVO." + field.getModel() + ".drop}";
                            element = MyGridComplex.generate(field.getName(),
                                    "complex",
                                    elementId,
                                    "text" + elementId,
                                    "drop" + elementId,
                                    expressionText,
                                    expressionDrop);
                            break;
                        case CUSTOM:
                            expression = "#{dynamicBean.dynamicModelVO." + field.getModel() + "}";
                            element = MyGridInputText.generate(field.getName(), "text", elementId, expression);
                            break;                            
                        default:
                            expression = "#{dynamicBean.dynamicModelVO." + field.getModel() + "}";
                            element = MyGridInputText.generate(field.getName(), "text", elementId, expression);
                            break;
                    }
                    gridField.getChildren().add(element);

                    gridColumn.getChildren().add(gridField);
                    z++;
                }

                gridBlockColumns.getChildren().add(gridColumn);

                j++;
            }

            gridBlock.getChildren().add(gridBlockColumns);

            formFromCode.getChildren().add(gridBlock);
            i++;
        }

    }

    public void reset() {
        //TODO reset values
        dynamicModelVO = new DynamicModelVO();
    }

    public void save() {
        //TODO save to DB
    }

    private void createDynamicFormModel() {
        //create DynamicFormVO in code
        Field fieldA1a = new Field();
        Field fieldA1b = new Field();
        Field fieldA1c = new Field();

        Field fieldA2a = new Field();
        Field fieldA2b = new Field();

        Field fieldA3a = new Field();
        Field fieldA3b = new Field();
        Field fieldA3c = new Field();

        Field fieldB1a = new Field();
        Field fieldB1b = new Field();
        Field fieldB1c = new Field();
        Field fieldB1d = new Field();

        Field fieldB2a = new Field();
        Field fieldB2b = new Field();
        Field fieldB2c = new Field();
        Field fieldB2d = new Field();
        Field fieldB2e = new Field();
        Field fieldB2f = new Field();
        Field fieldB2g = new Field();

        //Name
        fieldA1a.setName("Field A1a");
        fieldA1b.setName("Field A1b");
        fieldA1c.setName("Field A1c");

        fieldA2a.setName("Field A2a");
        fieldA2b.setName("Field A2b");

        fieldA3a.setName("Field A3a");
        fieldA3b.setName("Field A3b");
        fieldA3c.setName("Field A3c");

        fieldB1a.setName("Field B1a");
        fieldB1b.setName("Field B1b");
        fieldB1c.setName("Field B1c");
        fieldB1d.setName("Field B1d");

        fieldB2a.setName("Field B2a");
        fieldB2b.setName("Field B2b");
        fieldB2c.setName("Field B2c");
        fieldB2d.setName("Field B2d");
        fieldB2e.setName("Field B2e");
        fieldB2f.setName("Field B2f");
        fieldB2g.setName("Field B2g");

        //Type
        fieldA1a.setType(FieldType.TEXT);
        fieldA1b.setType(FieldType.TEXT);
        fieldA1c.setType(FieldType.TEXT);

        fieldA2a.setType(FieldType.TEXT);
        fieldA2b.setType(FieldType.TEXT);

        fieldA3a.setType(FieldType.TEXT);
        fieldA3b.setType(FieldType.TEXT);
        fieldA3c.setType(FieldType.TEXT);

        fieldB1a.setType(FieldType.TEXT);
        fieldB1b.setType(FieldType.CALENDAR);
        fieldB1c.setType(FieldType.RADIO);
        fieldB1d.setType(FieldType.COMPLEX);

        fieldB2a.setType(FieldType.TEXT);
        fieldB2b.setType(FieldType.TEXT);
        fieldB2c.setType(FieldType.TEXT);
        fieldB2d.setType(FieldType.TEXT);
        fieldB2e.setType(FieldType.TEXT);
        fieldB2f.setType(FieldType.CUSTOM); //Make a custom fields
        fieldB2g.setType(FieldType.CUSTOM); //Make a custom fields

        //Field of the model
        fieldA1a.setModel("firstname");
        fieldA1b.setModel("middlename");
        fieldA1c.setModel("lastname");

        fieldA2a.setModel("country");
        fieldA2b.setModel("city");

        fieldA3a.setModel("street");
        fieldA3b.setModel("number");
        fieldA3c.setModel("appendix");

        fieldB1a.setModel("ordername");
        fieldB1b.setModel("date");
        fieldB1c.setModel("selectorder");
        fieldB1d.setModel("amount");//TODO: hot to split expression? or not?

        fieldB2a.setModel("deliverycountry");
        fieldB2b.setModel("deliverycity");
        fieldB2c.setModel("deliverystreet");
        fieldB2d.setModel("deliverynumber");
        fieldB2e.setModel("deliveryappendix");
        fieldB2f.setModel("customFields[0]");
        fieldB2g.setModel("customFields[1]");

        List<Field> fieldsA1 = new ArrayList<>();
        List<Field> fieldsA2 = new ArrayList<>();
        List<Field> fieldsA3 = new ArrayList<>();
        List<Field> fieldsB1 = new ArrayList<>();
        List<Field> fieldsB2 = new ArrayList<>();

        fieldsA1.add(fieldA1a);
        fieldsA1.add(fieldA1b);
        fieldsA1.add(fieldA1c);

        fieldsA2.add(fieldA2a);
        fieldsA2.add(fieldA2b);

        fieldsA3.add(fieldA3a);
        fieldsA3.add(fieldA3b);
        fieldsA3.add(fieldA3c);

        fieldsB1.add(fieldB1a);
        fieldsB1.add(fieldB1b);
        fieldsB1.add(fieldB1c);
        fieldsB1.add(fieldB1d);

        fieldsB2.add(fieldB2a);
        fieldsB2.add(fieldB2b);
        fieldsB2.add(fieldB2c);
        fieldsB2.add(fieldB2d);
        fieldsB2.add(fieldB2e);
        fieldsB2.add(fieldB2f);
        fieldsB2.add(fieldB2g);

        Column columnA1 = new Column();
        Column columnA2 = new Column();
        Column columnA3 = new Column();
        Column columnB1 = new Column();
        Column columnB2 = new Column();

        columnA1.setName("Column A1");
        columnA2.setName("Column A2");
        columnA3.setName("Column A3");
        columnB1.setName("Column B1");
        columnB2.setName("Column B2");

        columnA1.setFields(fieldsA1);
        columnA2.setFields(fieldsA2);
        columnA3.setFields(fieldsA3);
        columnB1.setFields(fieldsB1);
        columnB2.setFields(fieldsB2);

        List<Column> columnsA = new ArrayList<>();
        List<Column> columnsB = new ArrayList<>();
        columnsA.add(columnA1);
        columnsA.add(columnA2);
        columnsA.add(columnA3);
        columnsB.add(columnB1);
        columnsB.add(columnB2);

        Block blockA = new Block();
        Block blockB = new Block();

        blockA.setName("Block A");
        blockB.setName("Block B");

        blockA.setColumns(columnsA);
        blockB.setColumns(columnsB);

        List<Block> blocks = new ArrayList<>();
        blocks.add(blockA);
        blocks.add(blockB);

        dynamicFormVO = new DynamicFormVO();
        dynamicFormVO.setName("Complete form");
        dynamicFormVO.setBlocks(blocks);
    }

    private void initDataModel() {
        //TODO: init data in DunamicModelVO
        dynamicModelVO = new DynamicModelVO();
        //Initialize values
        dynamicModelVO.setFirstname("Polle");
        dynamicModelVO.setMiddlename("JR");
        dynamicModelVO.setLastname("Parmentier");

        dynamicModelVO.setCity("Belgium");
        dynamicModelVO.setCity("Vichte");

        dynamicModelVO.setDate(new Date());
        dynamicModelVO.setAmount(new ComplexVO());
        List<String> l = new ArrayList<>();
        l.add("");
        l.add("");
        dynamicModelVO.setCustomFields(l);
    }

    /**
     * @return the dynamicFormVO
     */
    public DynamicFormVO getDynamicFormVO() {
        return dynamicFormVO;
    }

    /**
     * @param dynamicFormVO the dynamicFormVO to set
     */
    public void setDynamicFormVO(DynamicFormVO dynamicFormVO) {
        this.dynamicFormVO = dynamicFormVO;
    }

    /**
     * @return the dynamicModelVO
     */
    public DynamicModelVO getDynamicModelVO() {
        return dynamicModelVO;
    }

    /**
     * @param dynamicModelVO the dynamicModelVO to set
     */
    public void setDynamicModelVO(DynamicModelVO dynamicModelVO) {
        this.dynamicModelVO = dynamicModelVO;
    }

    /**
     * @return the formFromCode
     */
    public HtmlPanelGroup getFormFromCode() {
        return formFromCode;
    }

    /**
     * @param formFromCode the formFromCode to set
     */
    public void setFormFromCode(HtmlPanelGroup formFromCode) {
        this.formFromCode = formFromCode;
    }

}
