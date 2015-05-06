package be.feesboek.converters;

import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

@Named
@Stateless
@FacesConverter("be.feesboek.converters.IntegerConverter")
public class IntegerConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

//        if (value != null && !value.trim().isEmpty()) {
//            String part = value.replaceAll("Formated:", "");
//            Integer output = Integer.valueOf(part);
//        }
//        return null;
        
        return value;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            return "Formated:" + (Integer) object;
        }
        return null;
    }
}
