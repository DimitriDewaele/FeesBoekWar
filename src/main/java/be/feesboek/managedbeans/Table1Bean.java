package be.feesboek.managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "table1Bean")
@RequestScoped
public class Table1Bean {
    
    private List<String> firstTable;
    private String firstInput;

    @PostConstruct
    public void postConstruct() {
        firstTable = new ArrayList<>();
        firstTable.add("Item 1");
        firstTable.add("Item 2");
        firstTable.add("Item 3");
        firstTable.add("Item 4");
        firstTable.add("Item 5");
        
        firstInput = "First input";
    }

    public List<String> getFirstTable() {
        return firstTable;
    }

    public void setFirstTable(List<String> firstTable) {
        this.firstTable = firstTable;
    }

    /**
     * @return the firstInput
     */
    public String getFirstInput() {
        return firstInput;
    }

    /**
     * @param firstInput the firstInput to set
     */
    public void setFirstInput(String firstInput) {
        this.firstInput = firstInput;
    }
}
