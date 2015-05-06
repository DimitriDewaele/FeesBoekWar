package be.feesboek.managedbeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.Min;

/**
 *
 * @author dimitridw
 */
@Named(value = "validatorBean")
@SessionScoped
public class ValidatorBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ValidatorBean.class);

    private Long field1 = 111L;
    private Long field2 = 222L;
    @Min(1000)
    private Long field3 = 333L;
    private Long field4 = 444L;
    private Long field5 = 555L;
    private Long field6 = 666L;

    //Multiple field validation
    private Long field7 = 100L;
    private Long field8 = 100000L;
    private Long field9 = 99L;
    private Long field10 = 999999L;
    private Long field11 = 50L;
    private Long field12 = 500000L;
    private Long field13 = 44L;
    private Long field14 = 444444L;

    /**
     * Creates a new instance of ValidatorBean
     */
    public ValidatorBean() {
    }

    public void validate1(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        // No validation here - set value + validation in validate2
        this.field7 = (Long) value;
        LOGGER.debug("Entering ValidateRange with: {} and {}", field7, field8);
    }

    public void validate2(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        this.field8 = (Long) value;
        LOGGER.debug("Entering ValidateRange with: {} and {}", field7, field8);
        if (field7 < 1000L) {
            FacesMessage message = new FacesMessage("Field 7 is lower than 1000");
            context.addMessage(component.getClientId(context), message);
        }

        if (field8 > 2000L) {
            FacesMessage message = new FacesMessage("Field 8 is higher than 2000");
            context.addMessage(component.getClientId(context), message);
        }
    }

    public void validateRange(ComponentSystemEvent event) {

        FacesContext context = FacesContext.getCurrentInstance();

        UIComponent components = event.getComponent();

        // get password
        UIInput input13 = (UIInput) components.findComponent("field13");
        UIInput input14 = (UIInput) components.findComponent("field14");

        Object value13 = input13.getLocalValue() == null ? "" : input13.getLocalValue().toString();
        Object value14 = input14.getLocalValue() == null ? "" : input14.getLocalValue().toString();

        Long long13 = Long.valueOf(value13.toString());
        Long long14 = Long.valueOf(value14.toString());

        LOGGER.debug("Entering RangeValidator with: {} and {}", long13, long14);
        if (long13 < 1000L) {
            FacesMessage message = new FacesMessage("Field 13 lower than 1000");
            context.addMessage(input13.getClientId(context), message);
        }

        if (long14 > 2000L) {
            FacesMessage message = new FacesMessage("Field 14 is higher than 2000");
            context.addMessage(input14.getClientId(context), message);
        }
    }

    /**
     * @return the field1
     */
    public Long getField1() {
        return field1;
    }

    /**
     * @param field1 the field1 to set
     */
    public void setField1(Long field1) {
        this.field1 = field1;
    }

    /**
     * @return the field2
     */
    public Long getField2() {
        return field2;
    }

    /**
     * @param field2 the field2 to set
     */
    public void setField2(Long field2) {
        this.field2 = field2;
    }

    /**
     * @return the field3
     */
    public Long getField3() {
        return field3;
    }

    /**
     * @param field3 the field3 to set
     */
    public void setField3(Long field3) {
        this.field3 = field3;
    }

    /**
     * @return the field4
     */
    public Long getField4() {
        return field4;
    }

    /**
     * @param field4 the field4 to set
     */
    public void setField4(Long field4) {
        this.field4 = field4;
    }

    /**
     * @return the field5
     */
    public Long getField5() {
        return field5;
    }

    /**
     * @param field5 the field5 to set
     */
    public void setField5(Long field5) {
        this.field5 = field5;
    }

    /**
     * @return the field6
     */
    public Long getField6() {
        return field6;
    }

    /**
     * @param field6 the field6 to set
     */
    public void setField6(Long field6) {
        this.field6 = field6;
    }

    /**
     * @return the field7
     */
    public Long getField7() {
        return field7;
    }

    /**
     * @param field7 the field7 to set
     */
    public void setField7(Long field7) {
        this.field7 = field7;
    }

    /**
     * @return the field8
     */
    public Long getField8() {
        return field8;
    }

    /**
     * @param field8 the field8 to set
     */
    public void setField8(Long field8) {
        this.field8 = field8;
    }

    /**
     * @return the field9
     */
    public Long getField9() {
        return field9;
    }

    /**
     * @param field9 the field9 to set
     */
    public void setField9(Long field9) {
        this.field9 = field9;
    }

    /**
     * @return the field10
     */
    public Long getField10() {
        return field10;
    }

    /**
     * @param field10 the field10 to set
     */
    public void setField10(Long field10) {
        this.field10 = field10;
    }

    /**
     * @return the field11
     */
    public Long getField11() {
        return field11;
    }

    /**
     * @param field11 the field11 to set
     */
    public void setField11(Long field11) {
        this.field11 = field11;
    }

    /**
     * @return the field12
     */
    public Long getField12() {
        return field12;
    }

    /**
     * @param field12 the field12 to set
     */
    public void setField12(Long field12) {
        this.field12 = field12;
    }

    /**
     * @return the field13
     */
    public Long getField13() {
        return field13;
    }

    /**
     * @param field13 the field13 to set
     */
    public void setField13(Long field13) {
        this.field13 = field13;
    }

    /**
     * @return the field14
     */
    public Long getField14() {
        return field14;
    }

    /**
     * @param field14 the field14 to set
     */
    public void setField14(Long field14) {
        this.field14 = field14;
    }
}
