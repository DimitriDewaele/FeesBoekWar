package be.feesboek.business.user.control;

import be.feesboek.entity.CountryEntity;
import be.feesboek.entity.CountryEntity_;
import be.feesboek.entity.UserEntity;
import be.feesboek.entity.UserEntity_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
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

    // Using an named Query
    public List<UserEntity> findAllByNamedQuery() {
        TypedQuery<UserEntity> query = em.createNamedQuery("UserEntity.findAll", UserEntity.class);
        return query.getResultList();
    }

    // Using the Criteria Builder API
    public List<UserEntity> findAllByBuilder() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(UserEntity.class);

        Root<UserEntity> user = cq.from(UserEntity.class);
        cq.select(user);

        TypedQuery query = em.createQuery(cq);

        return query.getResultList();
    }

    public void save(UserEntity entity) {
        em.persist(entity);
    }

    // Using JPQL - The Java Persistence Query language
    public List<UserEntity> findAllSorted() {
        TypedQuery<UserEntity> tq = em.createQuery("SELECT u FROM UserEntity u ORDER BY u.username", UserEntity.class);
        return tq.getResultList();
    }

    // Using JPQL - The Java Persistence Query language
    public List<UserEntity> findAllFromCountry(String countryISO) {
        TypedQuery<UserEntity> tq = em
                .createQuery("SELECT u FROM UserEntity u WHERE u.country.countryIsoCode = :countryISO ORDER BY u.username", UserEntity.class)
                .setParameter("countryISO", countryISO);
        return tq.getResultList();
    }

    // Using JPQL - The Java Persistence Query language
    public Long findMaxId() {
        TypedQuery<Long> tq = em
                .createQuery("SELECT MAX(u.userId) FROM UserEntity u", Long.class);
        return tq.getSingleResult();
    }

    // Using the Criteria Builder API with MetaModel
    public List<UserEntity> findAllFromCountryModel(String countryISO) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);

        Root<UserEntity> user = cq.from(UserEntity.class);
        Join<UserEntity, CountryEntity> country = user.join(UserEntity_.country);

        cq.select(user);
        cq.where(cb.equal(country.get(CountryEntity_.countryIsoCode), countryISO));

        cq.orderBy(cb.asc(user.get(UserEntity_.username)));

        TypedQuery<UserEntity> tq = em.createQuery(cq);

        return tq.getResultList();
    }

    // Using the Criteria Builder API with MetaModel
    public Long findMaxIdModel() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);

        Root<UserEntity> user = cq.from(UserEntity.class);

        cq.select(cb.max(user.get(UserEntity_.userId)));

        TypedQuery<Long> tq = em.createQuery(cq);

        return tq.getSingleResult();
    }

    public UserEntity findByUserName(String userName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> user = cq.from(UserEntity.class);
        cq.select(user);
        cq.where(cb.equal(user.get(UserEntity_.username), userName));

        TypedQuery<UserEntity> tq = em.createQuery(cq);

        return tq.getSingleResult();
    }

    public UserEntity findByUserNameWithCountry(String userName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> cq = cb.createQuery(UserEntity.class);
        Root<UserEntity> user = cq.from(UserEntity.class);
        
        cq.select(user);
        cq.where(cb.equal(user.get(UserEntity_.username), userName));

        TypedQuery<UserEntity> tq = em.createQuery(cq);

        return tq.getSingleResult();
    }
}
