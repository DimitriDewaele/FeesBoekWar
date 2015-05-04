package be.feesboek.validators;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@Stateless
@FacesValidator("be.feesboek.validators.LongValidator")
public class LongValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

        Long input = null;

        if (value != null) {
            input = Long.valueOf(value.toString());
        }

        if (input == null || input < 1000L) {
            FacesMessage message = new FacesMessage("Smaller than 1000", "The value is to low, need more than 1000.");
            context.addMessage(component.getClientId(context), message);
        }

    }
}
