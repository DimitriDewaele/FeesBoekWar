package be.feesboek.managedbeans;

import be.feesboek.business.DialogDataBoundary;
import be.feesboek.models.PersonVO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author dimitridw
 */
@Named(value = "dialogPersonBean")
@RequestScoped
public class DialogPersonBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DialogPersonBean.class);

    private PersonVO detail;

    @Inject
    DialogDataBoundary dialogDataBoundary;

    /**
     * Creates a new instance of PersonBean
     */
    public DialogPersonBean() {
        List<String> requestParamList = (ArrayList) RequestContext.getCurrentInstance().getAttributes().get("data");
        LOGGER.debug("requestParamList: {}", requestParamList);

        Integer contextParam = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("data");
        LOGGER.debug("contextParam    : {}", contextParam);

        Integer id = null;
        if (requestParamList != null) {
            String idString = requestParamList.get(0);
            id = Integer.valueOf(idString);
        }
        if (id != null) {
            detail = dialogDataBoundary.getById(id);
        } else {
            detail = new PersonVO();
        }

        LOGGER.debug("personVO        : {}", detail);
    }

    @PostConstruct
    public void initialize() {

    }

    /**
     * @return the detail
     */
    public PersonVO getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(PersonVO detail) {
        this.detail = detail;
    }

}
