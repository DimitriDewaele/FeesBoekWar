package be.test.mavenwebapplication.beans;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
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
    
    private int personId;
    private String value1 = "a";
    private String value2 = "b";
    private int counter;
    private PersonVO person;
    
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
    
    public void getPersonFromId() {
        System.out.println("getPersonFromId:" + personId);
        person = new PersonVO(personId, "First", "Last", "development", new Date());
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

    /**
     * @return the personId
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * @param personId the personId to set
     */
    public void setPersonId(int personId) {
        System.out.println("setPersonId:" + personId);
        this.personId = personId;
    }

    /**
     * @return the person
     */
    public PersonVO getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(PersonVO person) {
        this.person = person;
    }
}
