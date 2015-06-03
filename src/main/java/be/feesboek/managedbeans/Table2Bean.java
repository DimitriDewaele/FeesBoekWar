package be.feesboek.managedbeans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "table2Bean")
@RequestScoped
public class Table2Bean {

    private List<String> secondTable;
    private String secondInput;

    @PostConstruct
    public void postConstruct() {
        secondTable = new ArrayList<>();
        secondTable.add("Text 1");
        secondTable.add("Text 2");
        secondTable.add("Text 3");
        
        secondInput = "Second input";
    }

    public List<String> getSecondTable() {
        return secondTable;
    }

    public void setSecondTable(List<String> secondTable) {
        this.secondTable = secondTable;
    }

    /**
     * @return the secondInput
     */
    public String getSecondInput() {
        return secondInput;
    }

    /**
     * @param secondInput the secondInput to set
     */
    public void setSecondInput(String secondInput) {
        this.secondInput = secondInput;
    }

}
