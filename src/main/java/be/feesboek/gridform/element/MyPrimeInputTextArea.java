package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import org.primefaces.component.inputtextarea.InputTextarea;

public class MyPrimeInputTextArea {

    public MyPrimeInputTextArea() {
    }

    public static InputTextarea generate(String id, String inputLabel, String expression, String placeHolder) {
        
        InputTextarea element = new InputTextarea();
        
        element.setId(id);
        element.setPlaceholder(placeHolder);
        element.setValueExpression("value", Utility.createValueExpression(expression, String.class));
        element.setLabel(inputLabel); //Used in error message after Converter-check or Validation-check

        return element;
    }
}
