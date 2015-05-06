package be.feesboek.managedbeans;

import be.feesboek.models.PersonVO;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author dimitridw
 */
@Named(value = "dialogBean")
@RequestScoped
public class DialogBean {

    private List<PersonVO> persons;

    /**
     * Creates a new instance of DialogBean
     */
    public DialogBean() {
    }

    @PostConstruct
    public void initialize() {

        persons = new ArrayList<PersonVO>();
        persons.add(new PersonVO(1, "Jean", "Pol", "receptionist", new Date(74, 10, 10)));
        persons.add(new PersonVO(2, "Jef", "Snijders", "guardener", new Date(71, 10, 10)));
        persons.add(new PersonVO(3, "Piet", "Peters", "truck driver", new Date(64, 10, 10)));
        persons.add(new PersonVO(4, "Peet", "Polders", "professor", new Date(54, 10, 10)));
        persons.add(new PersonVO(5, "Nell", "Van Den Walle", "student", new Date(12, 10, 10)));
        persons.add(new PersonVO(6, "Nady", "Van Toren", "cleaning", new Date(98, 10, 10)));
        persons.add(new PersonVO(7, "Jenny", "De Koster", "police", new Date(45, 10, 10)));
        persons.add(new PersonVO(8, "Malena", "Zetterman", "air traffic controler", new Date(71, 10, 10)));
        persons.add(new PersonVO(9, "Medina", "Zegers", "test engineer", new Date(85, 10, 10)));
        persons.add(new PersonVO(10, "Horaire", "Safrina", "manager", new Date(47, 10, 10)));

        // Add random up to  10 rows - loaded in RequestScope
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(10);
        for (int j = 0; j < randomInt; j++) {
            persons.add(new PersonVO((11 + j), "Horaire", "Safrina", "manager", new Date(47, 10, 10)));
        }

    }

    public void viewPersons() {
        RequestContext.getCurrentInstance().openDialog("dialog/viewPersons");
    }

    public void viewPersonsCustomized() {
        Map<String, Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);

        RequestContext.getCurrentInstance().openDialog("dialog/viewPersons", options, null);
    }

    public void editPerson() {
        RequestContext.getCurrentInstance().openDialog("dialog/editPerson");
    }

    /**
     * @return the persons
     */
    public List<PersonVO> getPersons() {
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(List<PersonVO> persons) {
        this.persons = persons;
    }

}
