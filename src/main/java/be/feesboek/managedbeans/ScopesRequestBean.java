package be.feesboek.managedbeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "scopesRequestBean")
@RequestScoped
public class ScopesRequestBean {
    
    private String field;

    public ScopesRequestBean() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
    
}
