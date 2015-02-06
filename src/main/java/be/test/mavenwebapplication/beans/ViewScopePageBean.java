package be.test.mavenwebapplication.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named
@ViewScoped
public class ViewScopePageBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String value1 = "a";
    private String value2 = "b";
    private int counter;
    
    @PostConstruct
    private void init() {
        setValue1("initial value 1");
        setValue2("initial value 2");
        
    }

    ViewScopePageBean() {
        counter = 1;
    }
    
    public void doit() {
        setValue1("doit 1 - " + counter);
        setValue2("doit 2 - " + counter);
        counter++;
    }
    /**
     * @return the value1
     */
    public String getValue1() {
        return value1;
    }

    /**
     * @param value1 the value1 to set
     */
    public void setValue1(String value1) {
        this.value1 = value1;
    }

    /**
     * @return the value2
     */
    public String getValue2() {
        return value2;
    }

    /**
     * @param value2 the value2 to set
     */
    public void setValue2(String value2) {
        this.value2 = value2;
    }
}
