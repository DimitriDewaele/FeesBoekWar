package be.feesboek.models;

import java.io.Serializable;

public class ComplexVO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String text = "d";
    private String drop = "D";

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the drop
     */
    public String getDrop() {
        return drop;
    }

    /**
     * @param drop the drop to set
     */
    public void setDrop(String drop) {
        this.drop = drop;
    }
    
    
}
