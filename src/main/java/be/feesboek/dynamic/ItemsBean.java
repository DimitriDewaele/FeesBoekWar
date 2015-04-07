package be.feesboek.dynamic;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.model.SelectItem;

/**
 *
 * @author dimitridw
 */
@Named(value = "itemsBean")
@Dependent
public class ItemsBean {

    private List<SelectItem> items;

    @PostConstruct
    public void startup() {
        SelectItem itemA = new SelectItem("A", "Item A");
        SelectItem itemB = new SelectItem("B", "Item B");
        SelectItem itemC = new SelectItem("C", "Item C");
        SelectItem itemD = new SelectItem("D", "Item D");

        items = new ArrayList<>();
        getItems().add(itemA);
        getItems().add(itemB);
        getItems().add(itemC);
        getItems().add(itemD);
    }

    /**
     * Creates a new instance of ItemsBean
     */
    public ItemsBean() {
    }

    /**
     * @return the items
     */
    public List<SelectItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<SelectItem> items) {
        this.items = items;
    }

}
