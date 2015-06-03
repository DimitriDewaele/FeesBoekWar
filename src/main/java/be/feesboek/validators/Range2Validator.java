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
@FacesValidator("be.feesboek.validators.Range2Validator")
public class Range2Validator implements Validator {
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Range2Validator.class);

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        // binding="#{input3}": This makes the component available elsewhere in the view
        // f:attribute: The value is added to this component and can be collected here.
        UIInput input3 = (UIInput) component.getAttributes().get("input3");

        Object value3 = input3.getSubmittedValue();

        Long longValue = Long.valueOf(value.toString());
        Long longValue3 = Long.valueOf(value3.toString());

        LOGGER.debug("Entering RangeValidator with: {} and {}", longValue, longValue3);
        if (longValue < 1000L) {
            ((UIInput) component).setValid(false);
            FacesMessage message = new FacesMessage("Field 11 lower than 1000");
            context.addMessage(component.getClientId(context), message);
        }

        if (longValue3 > 2000L) {
            ((UIInput) component).setValid(false);
            FacesMessage message = new FacesMessage("Field 12 is higher than 2000");
            context.addMessage(component.getClientId(context), message);
        }
    }
}
