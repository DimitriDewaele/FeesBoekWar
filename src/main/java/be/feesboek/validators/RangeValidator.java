package be.feesboek.validators;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@Stateless
@FacesValidator("be.feesboek.validators.RangeValidator")
public class RangeValidator implements Validator {
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RangeValidator.class);

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        // binding="#{input1}": This makes the component available elsewhere in the view
        // f:attribute: The value is added to this component and can be collected here.
        UIInput input1 = (UIInput) component.getAttributes().get("input1");
        UIInput input2 = (UIInput) component.getAttributes().get("input2");

        Object value1 = input1.getSubmittedValue();
        Object value2 = input2.getSubmittedValue();

        Long long1 = Long.valueOf(value1.toString());
        Long long2 = Long.valueOf(value2.toString());

        LOGGER.debug("Entering RangeValidator with: {} and {}", long1, long2);
        if (long1 < 1000L) {
            ((UIInput) component).setValid(false);
            FacesMessage message = new FacesMessage("Field 9 lower than 1000");
            context.addMessage(component.getClientId(context), message);
        }

        if (long2 > 2000L) {
            ((UIInput) component).setValid(false);
            FacesMessage message = new FacesMessage("Field 10 is higher than 2000");
            context.addMessage(component.getClientId(context), message);
        }
    }
}
