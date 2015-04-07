package be.feesboek.dynamic;

import be.feesboek.beans.ComplexVO;
import be.feesboek.dynamic.form.Column;
import be.feesboek.dynamic.form.Block;
import be.feesboek.dynamic.form.Field;
import be.feesboek.gridform.MyPanelGroup;
import be.feesboek.gridform.MyPrimePanelGrid;
import be.feesboek.gridform.component.MyGridComplex;
import be.feesboek.gridform.component.MyGridDate;
import be.feesboek.gridform.component.MyGridInputText;
import be.feesboek.gridform.component.MyGridRadio;
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

    private DynamicFormVO dynamicFormVO2;
    private DynamicModelVO dynamicModelVO2;
    private transient HtmlPanelGroup formFromCode2;

    @PostConstruct
    public void init() {

        // initialize the form Model
        initFormModel();

        // initialize the data Model
        initDataModel();

        // create the from object
        formFromCode = createForm(dynamicFormVO,1);

        //Test for alternative model with other user (limited model)
        // initialize the form Model
        initFormModel2();

        // initialize the data Model
        initDataModel2();

        // create the from object
        formFromCode2 = createForm(dynamicFormVO2,2);
    }

    public void reset() {
        //TODO reset values
        dynamicModelVO = new DynamicModelVO();
        dynamicModelVO2 = new DynamicModelVO();
    }

    public void save() {
        //TODO save to DB
    }

    private void initFormModel() {
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
        fieldA1a.setName("Firstname");
        fieldA1b.setName("Middlename");
        fieldA1c.setName("Lastname");

        fieldA2a.setName("Country");
        fieldA2b.setName("City");

        fieldA3a.setName("Street");
        fieldA3b.setName("Number");
        fieldA3c.setName("Appendix");

        fieldB1a.setName("Ordername");
        fieldB1b.setName("Date");
        fieldB1c.setName("Select order");
        fieldB1d.setName("Amount");

        fieldB2a.setName("Delivery country");
        fieldB2b.setName("Delivery city");
        fieldB2c.setName("Delivery street");
        fieldB2d.setName("Delivery number");
        fieldB2e.setName("Delivery appendix");
        fieldB2f.setName("Custom field 1");
        fieldB2g.setName("Custom field 2");

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
        fieldB2f.setType(FieldType.CUSTOM);
        fieldB2g.setType(FieldType.CUSTOM);

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
        fieldB1d.setModel("amount");

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
        l.add("AAA");
        l.add("BBB");
        dynamicModelVO.setCustomFields(l);
    }

    private void initFormModel2() {
        //create DynamicFormVO in code
        Field fieldA1a = new Field();
        Field fieldA1b = new Field();
        Field fieldA1c = new Field();
        Field fieldA1d = new Field();
        Field fieldA1e = new Field();

        Field fieldB1a = new Field();
        Field fieldB1b = new Field();
        Field fieldB1c = new Field();
        Field fieldB1d = new Field();

        Field fieldB2a = new Field();
        Field fieldB2b = new Field();
        Field fieldB2c = new Field();
        Field fieldB2d = new Field();

        //Name
        fieldA1a.setName("Firstname");
        fieldA1b.setName("Middlename");
        fieldA1c.setName("Lastname");
        fieldA1d.setName("Country");
        fieldA1e.setName("City");

        fieldB1a.setName("Ordername");
        fieldB1b.setName("Date");
        fieldB1c.setName("Select order");
        fieldB1d.setName("Amount");

        fieldB2a.setName("Custom field 1");
        fieldB2b.setName("Custom field 2");
        fieldB2c.setName("Custom field 3");
        fieldB2d.setName("Custom field 4");

        //Type
        fieldA1a.setType(FieldType.TEXT);
        fieldA1b.setType(FieldType.TEXT);
        fieldA1c.setType(FieldType.TEXT);
        fieldA1d.setType(FieldType.TEXT);
        fieldA1e.setType(FieldType.TEXT);

        fieldB1a.setType(FieldType.TEXT);
        fieldB1b.setType(FieldType.CALENDAR);
        fieldB1c.setType(FieldType.RADIO);
        fieldB1d.setType(FieldType.COMPLEX);

        fieldB2a.setType(FieldType.CUSTOM);
        fieldB2b.setType(FieldType.CUSTOM);
        fieldB2c.setType(FieldType.CUSTOM);
        fieldB2d.setType(FieldType.CUSTOM);

        //Field of the model
        fieldA1a.setModel("firstname");
        fieldA1b.setModel("middlename");
        fieldA1c.setModel("lastname");
        fieldA1d.setModel("country");
        fieldA1e.setModel("city");

        fieldB1a.setModel("ordername");
        fieldB1b.setModel("date");
        fieldB1c.setModel("selectorder");
        fieldB1d.setModel("amount");

        fieldB2a.setModel("customFields[0]");
        fieldB2b.setModel("customFields[1]");
        fieldB2c.setModel("customFields[2]");
        fieldB2d.setModel("customFields[3]");

        List<Field> fieldsA1 = new ArrayList<>();
        List<Field> fieldsB1 = new ArrayList<>();
        List<Field> fieldsB2 = new ArrayList<>();

        fieldsA1.add(fieldA1a);
        fieldsA1.add(fieldA1b);
        fieldsA1.add(fieldA1c);
        fieldsA1.add(fieldA1d);
        fieldsA1.add(fieldA1e);

        fieldsB1.add(fieldB1a);
        fieldsB1.add(fieldB1b);
        fieldsB1.add(fieldB1c);
        fieldsB1.add(fieldB1d);

        fieldsB2.add(fieldB2a);
        fieldsB2.add(fieldB2b);
        fieldsB2.add(fieldB2c);
        fieldsB2.add(fieldB2d);

        Column columnA1 = new Column();
        Column columnB1 = new Column();
        Column columnB2 = new Column();

        columnA1.setName("Column A1");
        columnB1.setName("Column B1");
        columnB2.setName("Column B2");

        columnA1.setFields(fieldsA1);
        columnB1.setFields(fieldsB1);
        columnB2.setFields(fieldsB2);

        List<Column> columnsA = new ArrayList<>();
        List<Column> columnsB = new ArrayList<>();
        columnsA.add(columnA1);
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

        dynamicFormVO2 = new DynamicFormVO();
        dynamicFormVO2.setName("Complete alternative form");
        dynamicFormVO2.setBlocks(blocks);
    }

    private void initDataModel2() {
        //TODO: init data in DunamicModelVO
        dynamicModelVO2 = new DynamicModelVO();
        //Initialize values
        dynamicModelVO2.setFirstname("Jeanne");
        dynamicModelVO2.setMiddlename("Ente");
        dynamicModelVO2.setLastname("Van Den Putte");

        dynamicModelVO2.setCity("Holland");
        dynamicModelVO2.setCity("Vlissingen");

        dynamicModelVO2.setDate(new Date());
        dynamicModelVO2.setAmount(new ComplexVO());
        List<String> l = new ArrayList<>();
        l.add("111");
        l.add("222");
        l.add("333");
        l.add("444");
        dynamicModelVO2.setCustomFields(l);
    }

    private HtmlPanelGroup createForm(DynamicFormVO formModel, int count) {
        //Create basic form
        HtmlPanelGroup form = MyPanelGroup.generateResponsive();
        
        //Run over the FormModel and create all form elements
        LOGGER.debug("START CREATE FORM");
        int i = 0;
        for (Block block : formModel.getBlocks()) {
            PanelGrid gridBlock = MyPrimePanelGrid.generateResponsive(1);

            LOGGER.debug("-BLOCK = {}", i);

            String blockId = "block-id-" + i;
            OutputLabel labelBlock = MyPrimeOutputLabel.generateWithIdAndLabel(block.getName(), blockId);
            gridBlock.getChildren().add(labelBlock);

            // Create a grid to put all columns next to each other.
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
                    
                    String elementId = "element-id-" + i + "-" + j + "-" + z;

                    //Don't add the field name above the field - this is added with the field.
                    //String fieldId = "field-id-" + i + "-" + j + "-" + z;
                    //OutputLabel labelField = MyPrimeOutputLabel.generateWithIdAndLabel(field.getName(), fieldId);
                    //gridField.getChildren().add(labelField);
                    

                    //Create field component
                    String expression = "";
                    String base = "#{dynamicBean.dynamicModelVO.";
                    if (count == 2 ) {
                        base = "#{dynamicBean.dynamicModelVO2.";    
                    }                    
                    HtmlPanelGroup element;
                    switch (field.getType()) {
                        case TEXT:
                            expression = base + field.getModel() + "}";
                            element = MyGridInputText.generate(field.getName(), "text", elementId, expression);
                            break;
                        case CALENDAR:
                            expression = base + field.getModel() + "}";
                            element = MyGridDate.generate(field.getName(), elementId, expression);
                            break;
                        case RADIO:
                            expression = base + field.getModel() + "}";
                            element = MyGridRadio.generate(field.getName(), elementId, expression);
                            break;
                        case COMPLEX:
                            String expressionText = base + field.getModel() + ".text}";
                            String expressionDrop = base + field.getModel() + ".drop}";
                            element = MyGridComplex.generate(field.getName(),
                                    "complex",
                                    elementId,
                                    "text" + elementId,
                                    "drop" + elementId,
                                    expressionText,
                                    expressionDrop);
                            break;
                        case CUSTOM:
                            expression = base + field.getModel() + "}";
                            element = MyGridInputText.generate(field.getName(), "text", elementId, expression);
                            break;
                        default:
                            expression = base + field.getModel() + "}";
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

            form.getChildren().add(gridBlock);
            i++;
        }
        
        return form;
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

    /**
     * @return the dynamicFormVO2
     */
    public DynamicFormVO getDynamicFormVO2() {
        return dynamicFormVO2;
    }

    /**
     * @param dynamicFormVO2 the dynamicFormVO2 to set
     */
    public void setDynamicFormVO2(DynamicFormVO dynamicFormVO2) {
        this.dynamicFormVO2 = dynamicFormVO2;
    }

    /**
     * @return the dynamicModelVO2
     */
    public DynamicModelVO getDynamicModelVO2() {
        return dynamicModelVO2;
    }

    /**
     * @param dynamicModelVO2 the dynamicModelVO2 to set
     */
    public void setDynamicModelVO2(DynamicModelVO dynamicModelVO2) {
        this.dynamicModelVO2 = dynamicModelVO2;
    }

    /**
     * @return the formFromCode2
     */
    public HtmlPanelGroup getFormFromCode2() {
        return formFromCode2;
    }

    /**
     * @param formFromCode2 the formFromCode2 to set
     */
    public void setFormFromCode2(HtmlPanelGroup formFromCode2) {
        this.formFromCode2 = formFromCode2;
    }

}
