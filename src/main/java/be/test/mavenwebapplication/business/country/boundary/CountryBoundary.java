package be.test.mavenwebapplication.business.country.boundary;

import be.test.mavenwebapplication.business.country.control.CountryService;
import be.test.mavenwebapplication.entity.CountryEntity;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author dimitridw
 */
@Named
@SessionScoped
public class CountryBoundary implements Serializable{

    private static final long serialVersionUID = 1L;

    org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CountryBoundary.class);

    @Inject
    CountryService countryService;

    public List<CountryEntity> findAllByNamedQuery() {
        return countryService.findAllByNamedQuery();
    }

    public List<CountryEntity> findAllByBuilder() {
        return countryService.findAllByBuilder();
    }

    public void save(CountryEntity entity) {
        countryService.save(entity);
    }
    
    public CountryEntity findById(Long countryId) {
        return countryService.findById(countryId);
    }
}
