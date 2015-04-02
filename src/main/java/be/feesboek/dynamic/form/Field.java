package be.feesboek.dynamic.form;

import be.feesboek.dynamic.FieldType;

/**
 *
 * @author dimitridw
 */
public class Field {
    
    private FieldType type;
    private String name;
    private String model;
    
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

    /**
     * @return the type
     */
    public FieldType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(FieldType type) {
        this.type = type;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }
    
}
