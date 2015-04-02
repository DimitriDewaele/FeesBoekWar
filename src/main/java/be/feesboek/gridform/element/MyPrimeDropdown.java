package be.feesboek.gridform.element;

import be.feesboek.gridform.Utility;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UISelectItems;
import javax.faces.model.SelectItem;
import org.primefaces.component.selectonemenu.SelectOneMenu;

public class MyPrimeDropdown {

    public MyPrimeDropdown() {
    }

    public static SelectOneMenu generate(String id, String expression) {

        SelectOneMenu element = new SelectOneMenu();

        SelectItem itemA = new SelectItem("A", "Item A");
        SelectItem itemB = new SelectItem("B", "Item B");
        SelectItem itemC = new SelectItem("C", "Item C");
        SelectItem itemD = new SelectItem("D", "Item D");

        List<SelectItem> items = new ArrayList<>();
        items.add(itemA);
        items.add(itemB);
        items.add(itemC);
        items.add(itemD);

        UISelectItems itemsUI = new UISelectItems();
        itemsUI.setValue(items);

        element.setId(id);
        element.setValueExpression("value", Utility.createValueExpression(expression, String.class));
        element.getChildren().add(itemsUI);

        return element;
    }
}
