package be.feesboek.managedbeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "scopesBean")
@RequestScoped
public class ScopesBean {

    public void send() {
        //Do nothing
    }
    
}
