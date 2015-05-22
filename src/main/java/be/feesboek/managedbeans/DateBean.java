package be.feesboek.managedbeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@Named(value = "dateBean")
@SessionScoped
public class DateBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DateBean.class);

    private Date startDate;
    private Date endDate;
    private Integer days;

    private Date validationStartDate;
    private Date validationEndDate;
    private Integer validationDays;

    public void calculate() {
        if (startDate != null) {
            if (endDate != null) {
                //Calculate days
                long diff = endDate.getTime() - startDate.getTime();
                days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            } else if (days != null) {
                //Calculate endDate
                endDate = startDate;
                Calendar to = Calendar.getInstance();
                to.setTime(endDate);
                to.add(Calendar.DATE, days);
                endDate = to.getTime();
            }
        }
        //Do nothing when not all fields are filled in.
    }

    public void validateStartDate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        // No validation here - set value + validation in validateDays
        this.validationStartDate = (Date) value;
        LOGGER.debug("DateBean - validateStartDate - Start Date = {}", validationStartDate);
    }

    public void validateEndDate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        // No validation here - set value + validation in validateDays
        this.validationEndDate = (Date) value;
        LOGGER.debug("DateBean - validateEndDate   - End Date   = {}", validationEndDate);
    }

    public void validateDays(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        this.validationDays = (Integer) value;
        LOGGER.debug("DateBean - validateDays      - Days       = {}", validationDays);

        if (validationStartDate != null) {
            if (validationEndDate != null && validationDays != null) {
                //Calculate days
                long diff = validationEndDate.getTime() - validationStartDate.getTime();
                Integer correct = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                LOGGER.debug("DateBean - validateDays      - correct    = {}", correct);
                if (!correct.equals(validationDays)) {
                    ((UIInput) component).setValid(false);
                    
                    FacesMessage message = new FacesMessage("Days is not valid. Leave empty for calculation");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    context.addMessage(component.getClientId(context), message);
                }
            }
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }
}
