package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import java.util.Date;
import org.primefaces.component.calendar.Calendar;

public class MyPrimeDate {

    public MyPrimeDate() {
    }

    public static Calendar generate(String id, String expression) {
        
        Calendar element = new Calendar();
        
        element.setId(id);
        element.setValueExpression("value", Utility.createValueExpression(expression, Date.class));
        element.setPattern("dd-MM-yyyy");

        return element;
    }
}
