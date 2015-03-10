package be.test.mavenwebapplication.business.country.control;

import be.test.mavenwebapplication.business.user.control.UserService;
import be.test.mavenwebapplication.entity.CountryEntity;
import be.test.mavenwebapplication.entity.UserEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dimitridw
 */
@Stateless
public class CountryService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CountryService.class);

    @PersistenceContext
    EntityManager em;

    public List<CountryEntity> findAllByNamedQuery() {
        TypedQuery<CountryEntity> query = em.createNamedQuery("CountryEntity.findAll", CountryEntity.class);
        return query.getResultList();
    }

    public List<CountryEntity> findAllByBuilder() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(CountryEntity.class);

        Root<CountryEntity> country = cq.from(CountryEntity.class);

        TypedQuery query = em.createQuery(cq);

        return query.getResultList();
    }

    public void save(CountryEntity entity) {
        em.persist(entity);
    }

}
