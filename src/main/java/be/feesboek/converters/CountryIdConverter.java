package be.feesboek.converters;

import be.feesboek.business.country.boundary.CountryBoundary;
import be.feesboek.entity.CountryEntity;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Stateless
public class CountryIdConverter implements Converter {
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CountryIdConverter.class);
    
    @Inject
    CountryBoundary countryBoundary;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.trim().isEmpty()) {
            Long id = Long.valueOf(value);
            return countryBoundary.findById(id);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object != null) {
            CountryEntity country = (CountryEntity) object;
            
            LOGGER.debug("COUNTRY {}: {} [{}]", country.getCountryId(), country.getCountryName(), country.getCountryIsoCode());
//            return String.valueOf(country.getCountryName() + " ["+country.getCountryIsoCode()+"]");
            return String.valueOf(country.getCountryId());
        }
        return null;
    }
}
