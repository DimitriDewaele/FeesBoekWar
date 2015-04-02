package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import org.primefaces.component.spinner.Spinner;

public class MyPrimeSpinner {

    public MyPrimeSpinner() {
    }

    public static Spinner generate(String id, String inputLabel, String expression) {
        
        Spinner element = new Spinner();
        
        element.setId(id);
        element.setValueExpression("value", Utility.createValueExpression(expression, String.class));
        element.setLabel(inputLabel); //Used in error message after Converter-check or Validation-check

        return element;
    }
}
