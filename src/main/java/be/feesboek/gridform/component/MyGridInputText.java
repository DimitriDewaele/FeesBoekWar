package be.feesboek.gridform.component;

import be.feesboek.gridform.MyPanelGroup;
import be.feesboek.gridform.MyPrimePanelGrid;
import be.feesboek.gridform.element.MyPrimeInputText;
import be.feesboek.gridform.element.MyPrimeMessage;
import be.feesboek.gridform.element.MyPrimeOutputLabel;
import javax.faces.component.html.HtmlPanelGroup;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.message.Message;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;

public class MyGridInputText {
    
    public static HtmlPanelGroup generate() {

        String inputLabel = "text";
        String placeHolder = "text";
        String id = "text";
        String expression = "#{crazyBean.text}";

        // Group to fit the all in
        HtmlPanelGroup panelGroup = MyPanelGroup.generateResponsive();

        // Create a Grid
        PanelGrid panelGrid = MyPrimePanelGrid.generateResponsive(3);

        // Create a label component
        OutputLabel label = MyPrimeOutputLabel.generate(inputLabel, id);

        // Create the input text.
        InputText text = MyPrimeInputText.generate(id, inputLabel, expression, placeHolder);

        // Create message for this component
        Message message = MyPrimeMessage.generate(id);

        panelGrid.getChildren().add(label);
        panelGrid.getChildren().add(text);
        panelGrid.getChildren().add(message);

        panelGroup.getChildren().add(panelGrid);

        return panelGroup;
    }
    
}
