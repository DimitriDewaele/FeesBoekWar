package be.feesboek.managedbeans;

import be.feesboek.business.DialogDataBoundary;
import be.feesboek.models.PersonVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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

    private List<PersonVO> persons;

    @Inject
    DialogDataBoundary dialogDataBoundary;

    /**
     * Creates a new instance of DialogBean
     */
    public DialogBean() {
    }

    @PostConstruct
    public void initialize() {
        persons = dialogDataBoundary.findAll();
    }

    public void add() {
        LOGGER.debug("Add person");

        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("draggable", true);
        options.put("resizable", true);
        options.put("contentHeight", 200);

        RequestContext.getCurrentInstance().openDialog("dialog/addPerson", options, null);
    }

    public void edit(int id) {
        LOGGER.debug("Edit person with ID: {}", id);

        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("draggable", true);
        options.put("resizable", true);
        options.put("contentHeight", 200);

        Integer personId = Integer.valueOf(id);

        List<String> paramList = new ArrayList<>();
        paramList.add(personId.toString());

        Map<String, List<String>> params = new HashMap<>();
        params.put("data", paramList);
        LOGGER.debug("paramList: {}", paramList);

        RequestContext.getCurrentInstance().openDialog("dialog/editPerson", options, params);

        // Seems to ben necessary - does not bind good with Requestcontext
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("personId", personId);
    }

    public void remove(int id) {
        LOGGER.debug("Remove person with ID: {}", id);

        Map<String, Object> options = new HashMap<>();
        options.put("modal", false);
        options.put("draggable", true);
        options.put("resizable", true);
        options.put("contentHeight", 200);

        Integer personId = Integer.valueOf(id);

        List<String> paramList = new ArrayList<>();
        paramList.add(personId.toString());

        Map<String, List<String>> params = new HashMap<>();
        params.put("data", paramList);
        LOGGER.debug("paramList: {}", paramList);

        RequestContext.getCurrentInstance().openDialog("dialog/removePerson", options, params);

        // Seems to ben necessary - does not bind good with Requestcontext
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("personId", personId);
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
