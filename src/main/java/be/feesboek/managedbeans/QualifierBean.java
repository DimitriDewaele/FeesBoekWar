package be.feesboek.managedbeans;

import be.feesboek.qualifiers.Informal;
import be.feesboek.qualifiers.Official;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author dimitridw
 */
@Named(value = "qualifierBean")
@RequestScoped
public class QualifierBean {

    @Inject
    Greeting greeting1;

    @Inject
    @Informal
    Greeting greeting2;

    @Inject
    @Official
    Greeting greeting3;
    
    private String name;
    private String salution1;
    private String salution2;
    private String salution3;

    public QualifierBean() {
    }
    
    public void send() {
        salution1 = greeting1.greet(name);
        salution2 = greeting2.greet(name);
        salution3 = greeting3.greet(name);
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

    /**
     * @return the salution1
     */
    public String getSalution1() {
        return salution1;
    }

    /**
     * @param salution1 the salution1 to set
     */
    public void setSalution1(String salution1) {
        this.salution1 = salution1;
    }

    /**
     * @return the salution2
     */
    public String getSalution2() {
        return salution2;
    }

    /**
     * @param salution2 the salution2 to set
     */
    public void setSalution2(String salution2) {
        this.salution2 = salution2;
    }

    /**
     * @return the salution3
     */
    public String getSalution3() {
        return salution3;
    }

    /**
     * @param salution3 the salution3 to set
     */
    public void setSalution3(String salution3) {
        this.salution3 = salution3;
    }

}
