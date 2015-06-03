package be.feesboek.managedbeans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named(value = "scopesApplicationBean")
@ApplicationScoped
public class ScopesApplicationBean {

    private String field;
    
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
    
}
