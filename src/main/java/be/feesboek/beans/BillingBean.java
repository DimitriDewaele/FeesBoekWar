package be.feesboek.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named
@RequestScoped
public class BillingBean {
    
    private String choise;
    private String firstname="Polle";
    private String lastname="Pot";

    /**
     * @return the choise
     */
    public String getChoise() {
        return choise;
    }

    /**
     * @param choise the choise to set
     */
    public void setChoise(String choise) {
        this.choise = choise;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
}
