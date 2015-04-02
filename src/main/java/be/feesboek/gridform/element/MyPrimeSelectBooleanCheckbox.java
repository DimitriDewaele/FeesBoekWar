package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

public class MyPrimeSelectBooleanCheckbox {

    public MyPrimeSelectBooleanCheckbox() {
    }

    public static SelectBooleanCheckbox generate(String id, String inputLabel, String expression) {
        
        SelectBooleanCheckbox element = new SelectBooleanCheckbox();
        
        element.setId(id);
        element.setValueExpression("value", Utility.createValueExpression(expression, String.class));
        element.setLabel(inputLabel); //Used in error message after Converter-check or Validation-check

        return element;
    }
}
