package be.feesboek.converters;

import be.feesboek.business.DialogDataBoundary;
import be.feesboek.models.PersonVO;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class PersonVOIdConverter implements Converter {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PersonVOIdConverter.class);

    @Inject
    DialogDataBoundary dialogDataBoundary;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        LOGGER.debug("Convert ID to Person: {}", value);
        if (value != null && !value.trim().isEmpty()) {
            Integer id = Integer.valueOf(value);
            return dialogDataBoundary.getById(id);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        LOGGER.debug("Convert PersonVO to ID: {}", object);
        if (object != null) {
            PersonVO person = (PersonVO) object;
            return String.valueOf(person.getId());
        }
        return null;
    }
}
