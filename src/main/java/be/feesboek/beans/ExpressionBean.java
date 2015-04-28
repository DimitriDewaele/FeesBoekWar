package be.feesboek.beans;

import be.feesboek.models.PersonVO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author dimitridw
 */
@Named(value = "expressionBean")
@Dependent
public class ExpressionBean {
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ExpressionBean.class);

    private String testname;
    private PersonVO person;

    /**
     * Creates a new instance of ExpressionBean
     */
    public ExpressionBean() {
    }

    //Initialize the model
    @PostConstruct
    public void initialize() {
        
        // Year = starting vrom +1900
        // Month = zero based
        person = new PersonVO(1, "Ivan", "Dewaele", "pensioener", new Date(49, 0, 28));

        PersonVO child1 = new PersonVO(2, "Dimitri", "Dewaele", "Software Engineer", new Date(74, 9, 16));
        PersonVO child2 = new PersonVO(3, "Joost", "Dewaele", "Environmental Engineer", new Date(74, 9, 16));

        PersonVO grandchild1 = new PersonVO(4, "Thibaud", "Dewaele", "Student", new Date(105, 0, 5));
        PersonVO grandchild2 = new PersonVO(5, "Mathis", "Dewaele", "Student", new Date(106, 4, 28));
        PersonVO grandchild3 = new PersonVO(6, "Louise", "Dewaele", "Student", new Date(107, 8, 17));
        PersonVO grandchild4 = new PersonVO(7, "Julie", "Dewaele", "Student", new Date(108, 10, 25));
        PersonVO grandchild5 = new PersonVO(8, "Amélie", "Dewaele", "Student", new Date(108, 10, 25));

        List<PersonVO> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        person.setChildren(children);

        List<PersonVO> grandchildren = new ArrayList<>();
        grandchildren.add(grandchild1);
        grandchildren.add(grandchild2);
        grandchildren.add(grandchild3);
        grandchildren.add(grandchild4);
        grandchildren.add(grandchild5);

        child1.setChildren(grandchildren);
    }

    public String getGrandChild() {
        return searchGrandChild(0);
    }

    public String searchGrandChild() {
        return searchGrandChild(0);
    }

    public String searchGrandChild(int i) {
        //NOT error proof
        PersonVO grandchild = person.getChildren().get(0).getChildren().get(i);
        return grandchild.getFirstName();
    }

    /**
     * @return the testname
     */
    public String getTestname() {
        return testname;
    }

    /**
     * @param testname the testname to set
     */
    public void setTestname(String testname) {
        this.testname = testname;
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
