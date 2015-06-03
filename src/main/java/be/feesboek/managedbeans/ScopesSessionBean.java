package be.feesboek.managedbeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "scopesSessionBean")
@SessionScoped
public class ScopesSessionBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
    
}
