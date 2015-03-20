package be.feesboek.gridform.component;

import be.feesboek.gridform.MyPanelGroup;
import be.feesboek.gridform.MyPrimePanelGrid;
import be.feesboek.gridform.element.MyPrimeInputSwitch;
import be.feesboek.gridform.element.MyPrimeMessage;
import be.feesboek.gridform.element.MyPrimeOutputLabel;
import javax.faces.component.html.HtmlPanelGroup;
import org.primefaces.component.inputswitch.InputSwitch;
import org.primefaces.component.message.Message;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;

public class MyGridInputSwitch {
    
    public static HtmlPanelGroup generate() {

        String inputLabel = "switcher";
        String id = "switcher";
        String expression = "#{crazyBean.switcher}";

        // Group to fit the all in
        HtmlPanelGroup panelGroup = MyPanelGroup.generateResponsive();

        // Create a Grid
        PanelGrid panelGrid = MyPrimePanelGrid.generateResponsive(3);

        // Create a label component
        OutputLabel label = MyPrimeOutputLabel.generate(inputLabel, id);

        // Create the input text.
        InputSwitch inputSwitch = MyPrimeInputSwitch.generate(id, inputLabel, expression);

        // Create message for this component
        Message message = MyPrimeMessage.generate(id);

        panelGrid.getChildren().add(label);
        panelGrid.getChildren().add(inputSwitch);
        panelGrid.getChildren().add(message);

        panelGroup.getChildren().add(panelGrid);

        return panelGroup;
    }
    
}
