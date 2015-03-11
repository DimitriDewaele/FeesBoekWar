package be.test.mavenwebapplication.business.user.control;

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
//@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UserService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserService.class);

    @PersistenceContext
    EntityManager em;

    public List<UserEntity> findAllByNamedQuery() {
        TypedQuery<UserEntity> query = em.createNamedQuery("UserEntity.findAll", UserEntity.class);
        return query.getResultList();
    }
    
    public List<UserEntity> findAllByBuilder() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UserEntity.class);
        
        Root<UserEntity> user = cq.from(UserEntity.class);
        
        TypedQuery query = em.createQuery(cq);
        
        return query.getResultList();
    }
    
    public void save(UserEntity entity) {
        em.persist(entity);
    }
    
    public List<UserEntity> findAllSorted() {
        TypedQuery<UserEntity> tq = em.createQuery("SELECT u FROM UserEntity u ORDER BY u.username", UserEntity.class);
        return tq.getResultList();
    }

    public List<UserEntity> findAllFromCountry(String countryISO) {
        TypedQuery<UserEntity> tq = em
                .createQuery("SELECT u FROM UserEntity u WHERE u.country.countryIsoCode = :countryISO ORDER BY u.username", UserEntity.class)
                .setParameter("countryISO", countryISO);
        return tq.getResultList();
    }
    
    public Long findMaxId() {
        TypedQuery<Long> tq = em
                .createQuery("SELECT MAX(u.userId) FROM UserEntity u", Long.class);
        return tq.getSingleResult();
    }
}
