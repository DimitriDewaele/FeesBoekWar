package be.feesboek.dynamic.form;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dimitridw
 */
public class Block {

    private String name;
    private List<Column> columns = new ArrayList<>();

    /**
     * @return the columns
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
