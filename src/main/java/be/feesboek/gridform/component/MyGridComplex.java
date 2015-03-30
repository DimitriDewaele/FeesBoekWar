package be.feesboek.gridform.component;

import be.feesboek.gridform.MyPanelGroup;
import be.feesboek.gridform.MyPrimePanelGrid;
import be.feesboek.gridform.element.MyPrimeDropdown;
import be.feesboek.gridform.element.MyPrimeInputText;
import be.feesboek.gridform.element.MyPrimeMessage;
import be.feesboek.gridform.element.MyPrimeOutputLabel;
import javax.faces.component.html.HtmlPanelGroup;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.message.Message;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectonemenu.SelectOneMenu;

public class MyGridComplex {
    
    public static HtmlPanelGroup generate() {

        String inputLabel = "complex";
        String placeHolder = "complex";
        String id = "complex";
        String idtext = "complex-text";
        String iddrop = "complex-drop";
        String expression1 = "#{crazyBean.complexVO.text}";
        String expression2 = "#{crazyBean.complexVO.drop}";

        // Group to fit the all in
        HtmlPanelGroup panelGroup = MyPanelGroup.generateResponsive();

        // Create a Grid
        PanelGrid panelGrid = MyPrimePanelGrid.generateResponsive(3);

        // Create a label component
        OutputLabel label = MyPrimeOutputLabel.generate(inputLabel, id);

        // Create the complex component
        PanelGrid complexGrid = MyPrimePanelGrid.generateResponsiveWithId(1,id);
        InputText text = MyPrimeInputText.generate(idtext, inputLabel, expression1, placeHolder);
        SelectOneMenu drop = MyPrimeDropdown.generate(iddrop, expression2);
        complexGrid.getChildren().add(text);
        complexGrid.getChildren().add(drop);

        // Create message for this component
        Message message = MyPrimeMessage.generate(id);

        panelGrid.getChildren().add(label);
        panelGrid.getChildren().add(complexGrid);
        panelGrid.getChildren().add(message);

        panelGroup.getChildren().add(panelGrid);

        return panelGroup;
    }
    
}
