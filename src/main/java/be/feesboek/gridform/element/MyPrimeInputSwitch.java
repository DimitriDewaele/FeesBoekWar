package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import org.primefaces.component.inputswitch.InputSwitch;

public class MyPrimeInputSwitch {

    public MyPrimeInputSwitch() {
    }

    public static InputSwitch generate(String id, String inputLabel, String expression) {
        
        InputSwitch element = new InputSwitch();
        
        element.setId(id);
        element.setValueExpression("value", Utility.createValueExpression(expression, String.class));
        element.setLabel(inputLabel); //Used in error message after Converter-check or Validation-check

        return element;
    }
}
