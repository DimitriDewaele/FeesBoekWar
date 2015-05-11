package be.feesboek.managedbeans;

import be.feesboek.business.DialogDataBoundary;
import be.feesboek.models.PersonVO;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author dimitridw
 */
@Named(value = "dialogPersonBean")
@ViewScoped
public class DialogPersonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DialogPersonBean.class);

    private PersonVO person;

    @Inject
    DialogDataBoundary dialogDataBoundary;

    /**
     * Creates a new instance of PersonBean
     */
    public DialogPersonBean() {
    }

    @PostConstruct
    public void initialize() {
        LOGGER.debug("Postconstruct personVO: {}", person);
    }

    public long getDummyTime(){
        return System.currentTimeMillis();
    }
    
    public void edit() {
        LOGGER.debug("EDIT: {}", person);
        dialogDataBoundary.edit(person);
        RequestContext.getCurrentInstance().closeDialog("dialog/editPerson");
        RequestContext.getCurrentInstance().update(":personlist:datatable");
    }

    public void remove() {
        LOGGER.debug("REMOVE: {}", person);
        dialogDataBoundary.remove(person.getId());
        RequestContext.getCurrentInstance().closeDialog("dialog/removePerson");
        RequestContext.getCurrentInstance().update(":personlist:datatable");
    }

    public void nothing() {
        LOGGER.debug("Do nothing: {}", person);
        RequestContext.getCurrentInstance().closeDialog("dialog/removePerson");
        RequestContext.getCurrentInstance().update(":personlist:datatable");
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
