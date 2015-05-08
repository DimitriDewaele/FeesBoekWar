package be.feesboek.business;

import be.feesboek.models.PersonVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dimitridw
 */
@Named
@SessionScoped
public class DialogDataBoundary implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DialogDataBoundary.class);

    private List<PersonVO> persons;

    /**
     * Creates a new instance of DialogDataBean
     */
    public DialogDataBoundary() {
    }

    @PostConstruct
    public void initialize() {
        persons = new ArrayList<>();
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
    }

    public List<PersonVO> findAll() {
        return persons;
    }

    public PersonVO getById(int id) {
        PersonVO local = null;
        for (Iterator iter = persons.listIterator(); iter.hasNext();) {
            PersonVO temp = (PersonVO) iter.next();
            int idTemp = temp.getId();
            if (idTemp == id) {
                LOGGER.debug("The person is: {}", temp);
                local = temp;
                break;
            }
        }
        return local;
    }
    
    public int maxId() {
        return persons.size();
    }

    public void remove(int id) {
        PersonVO local = getById(id);
        if (local != null) {
            LOGGER.debug("Remove person: {}", local);
            persons.remove(local);
        }
    }

    public void add(PersonVO person) {
        persons.add(person);
    }

    public void edit(PersonVO person) {
        PersonVO local = getById(person.getId());
        local = person;
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
