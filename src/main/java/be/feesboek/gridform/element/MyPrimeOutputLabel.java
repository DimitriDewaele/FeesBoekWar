package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import org.primefaces.component.outputlabel.OutputLabel;

public final class MyPrimeOutputLabel {

    private MyPrimeOutputLabel() {
    }

    /**
     * Create a label
     *
     * @param inputLabel the text to put on the label
     * @param id id belonging to the input field
     * @return PanelGroup
     */
    public static OutputLabel generate(String inputLabel, String id) {

        OutputLabel element = new OutputLabel();
        element.setValue(inputLabel);
        element.setFor(id);

        return element;
    }
    
    public static OutputLabel generateWithId(String expression, String id) {

        OutputLabel element = new OutputLabel();
        element.setValueExpression("value", Utility.createValueExpression(expression, String.class));
        element.setId(id);

        return element;
    }
}
