package be.feesboek.gridform.component;

import be.feesboek.gridform.MyPanelGroup;
import be.feesboek.gridform.MyPrimePanelGrid;
import be.feesboek.gridform.element.MyPrimeMessage;
import be.feesboek.gridform.element.MyPrimeOutputLabel;
import be.feesboek.gridform.element.MyPrimeSpinner;
import javax.faces.component.html.HtmlPanelGroup;
import org.primefaces.component.message.Message;
import org.primefaces.component.outputlabel.OutputLabel;
import org.primefaces.component.panelgrid.PanelGrid;
import org.primefaces.component.spinner.Spinner;

public class MyGridSpinner {
    
    public static HtmlPanelGroup generate() {

        String inputLabel = "spinner";
        String placeHolder = "spinner";
        String id = "spinner";
        String expression = "#{crazyBean.spinner}";

        // Group to fit the all in
        HtmlPanelGroup panelGroup = MyPanelGroup.generateResponsive();

        // Create a Grid
        PanelGrid panelGrid = MyPrimePanelGrid.generateResponsive(3);

        // Create a label component
        OutputLabel label = MyPrimeOutputLabel.generateFor(inputLabel, id);

        // Create the input text.
        Spinner spinner = MyPrimeSpinner.generate(id, inputLabel, expression);

        // Create message for this component
        Message message = MyPrimeMessage.generate(id);

        panelGrid.getChildren().add(label);
        panelGrid.getChildren().add(spinner);
        panelGrid.getChildren().add(message);

        panelGroup.getChildren().add(panelGrid);

        return panelGroup;
    }
    
}
