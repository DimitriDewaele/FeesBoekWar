package be.feesboek.managedbeans;

import be.feesboek.business.DialogDataBoundary;
import be.feesboek.models.PersonVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author dimitridw
 */
@Named(value = "dialogBean")
@SessionScoped
public class DialogBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DialogBean.class);

    private String message;
    private List<PersonVO> persons;
    private PersonVO selected;

    @Inject
    DialogDataBoundary dialogDataBoundary;

    /**
     * Creates a new instance of DialogBean
     */
    public DialogBean() {
    }

    @PostConstruct
    public void initialize() {
        LOGGER.debug("DialogBean: initialize");
        persons = dialogDataBoundary.findAll();
        message = "General message";
    }

    public void fromCode() {
        LOGGER.debug("Dialog from code");
        RequestContext.getCurrentInstance().openDialog("dialog/testLoad");
    }

    public void test() {
        LOGGER.debug("TEST Method");
    }

    public long getOverviewDummyTime() {
        return System.currentTimeMillis();
    }

    public void updateForm() {
        LOGGER.debug("TEST");
        RequestContext.getCurrentInstance().update(":personlist");
    }

    public void nothing() {
        LOGGER.debug("Do nothing: {}");
    }

    public void newPerson() {
        LOGGER.debug("New person");
        this.selected = new PersonVO();
    }

    public void add() {
        LOGGER.debug("Add selected person: {}", selected);
        dialogDataBoundary.add(selected);
    }

    public void edit(PersonVO person) {
        LOGGER.debug("Edit person with ID: {}", person);
        dialogDataBoundary.edit(person);
    }

    public void remove(int id) {
        LOGGER.debug("Remove person with ID: {}", id);
        dialogDataBoundary.remove(id);
    }

    /**
     * @return the persons
     */
    public List<PersonVO> getPersons() {
        LOGGER.debug("DialogBean: getPersons");
        return persons;
    }

    /**
     * @param persons the persons to set
     */
    public void setPersons(List<PersonVO> persons) {
        LOGGER.debug("DialogBean: setPersons");
        this.persons = persons;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the selected
     */
    public PersonVO getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(PersonVO selected) {
        this.selected = selected;
    }

}
