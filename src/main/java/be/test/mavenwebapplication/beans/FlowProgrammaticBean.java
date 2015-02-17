package be.test.mavenwebapplication.beans;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named
@FlowScoped("flowProgrammatic")
public class FlowProgrammaticBean implements Serializable {

    private String value1;
    private String value2;
    private String value3;
    private String value4;

    private int personId;
    private PersonVO person;

    /**
     * Creates a new instance of FlowProgrammaticBean
     */
    public FlowProgrammaticBean() {
        System.out.println("CONSTRUCT");
    }
    
    public String getReturnValue() {
        return "/flowProgrammaticReturn";
    }

    @PostConstruct
    public void start() {
        System.out.println("START");
    }
    
    @PreDestroy
    public void end() {
        System.out.println("END");
    }
    
    public void loadPersonFromId() {
        System.out.println("loadPersonFromId:" + personId);
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
     * @return the value3
     */
    public String getValue3() {
        return value3;
    }

    /**
     * @param value3 the value3 to set
     */
    public void setValue3(String value3) {
        this.value3 = value3;
    }

    /**
     * @return the value4
     */
    public String getValue4() {
        return value4;
    }

    /**
     * @param value4 the value4 to set
     */
    public void setValue4(String value4) {
        this.value4 = value4;
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
