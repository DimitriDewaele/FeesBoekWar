package be.feesboek.managedbeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "customBean")
@SessionScoped
public class CustomBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CustomBean.class);
    
    private String field1="field1";

    /**
     * Creates a new instance of CustomBean
     */
    public CustomBean() {
    }
    
    public void add() {
        //TODO: do something
    }

    /**
     * @return the field1
     */
    public String getField1() {
        return field1;
    }

    /**
     * @param field1 the field1 to set
     */
    public void setField1(String field1) {
        this.field1 = field1;
    }
    
}
