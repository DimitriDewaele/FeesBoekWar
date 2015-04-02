package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import org.primefaces.component.inputtext.InputText;

public class MyPrimeInputText {

    public MyPrimeInputText() {
    }

    public static InputText generate(String id, String inputLabel, String expression, String placeHolder) {
        
        InputText element = new InputText();
        
        element.setId(id);
        element.setPlaceholder(placeHolder);
        element.setValueExpression("value", Utility.createValueExpression(expression, String.class));
        element.setLabel(inputLabel); //Used in error message after Converter-check or Validation-check

        return element;
    }
}
