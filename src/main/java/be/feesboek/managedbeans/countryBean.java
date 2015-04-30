package be.feesboek.managedbeans;

import be.feesboek.entity.CountryEntity;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author dimitridw
 */
@Named
@RequestScoped
public class countryBean {

    private CountryEntity country;

    /**
     * @return the country
     */
    public CountryEntity getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(CountryEntity country) {
        this.country = country;
    }
    
}
