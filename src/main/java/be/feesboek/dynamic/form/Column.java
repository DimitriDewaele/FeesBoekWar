package be.feesboek.dynamic.form;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dimitridw
 */
public class Column {
    
    private String name;
    private List<Field> fields = new ArrayList<>();

    /**
     * @return the fields
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * @param fields the fields to set
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
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
