package be.feesboek.gridform.component;

import be.feesboek.gridform.MyPanelGroup;
import be.feesboek.gridform.MyPrimePanelGrid;
import be.feesboek.gridform.element.MyPrimeMessage;
import be.feesboek.gridform.element.MyPrimeOutputLabel;
import be.feesboek.gridform.element.MyPrimeRadio;
import javax.faces.component.html.HtmlPanelGroup;
import org.primefaces.component.message.Message;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.selectoneradio.SelectOneRadio;

public class MyGridRadio {
    
    public static HtmlPanelGroup generate() {

        String inputLabel = "radio";
        String id = "radio";
        String expression = "#{crazyBean.radio}";

        // Group to fit the all in
        HtmlPanelGroup panelGroup = MyPanelGroup.generateResponsive();

        // Create a Grid
        PanelGrid panelGrid = MyPrimePanelGrid.generateResponsive(3);

        // Create a label component
        OutputLabel label = MyPrimeOutputLabel.generate(inputLabel, id);

        // Create the radio button.
        SelectOneRadio radio = MyPrimeRadio.generate(id, expression);

        // Create message for this component
        Message message = MyPrimeMessage.generate(id);

        panelGrid.getChildren().add(label);
        panelGrid.getChildren().add(radio);
        panelGrid.getChildren().add(message);

        panelGroup.getChildren().add(panelGrid);

        return panelGroup;
    }
    
}
