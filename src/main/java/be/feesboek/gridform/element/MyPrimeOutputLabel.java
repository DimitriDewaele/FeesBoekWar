package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import org.primefaces.component.outputlabel.OutputLabel;

public final class MyPrimeOutputLabel {

    private MyPrimeOutputLabel() {
    }

    public static OutputLabel generateFor(String inputLabel, String id) {

        OutputLabel element = new OutputLabel();
        element.setValue(inputLabel);
        element.setFor(id);

        return element;
    }
    
    public static OutputLabel generateWithIdAndLabel(String label, String id) {

        OutputLabel element = new OutputLabel();
        element.setValue(label);
        element.setId(id);

        return element;
    }
    
    public static OutputLabel generateWithId(String expression, String id) {

        OutputLabel element = new OutputLabel();
        element.setValueExpression("value", Utility.createValueExpression(expression, String.class));
        element.setId(id);

        return element;
    }
}
