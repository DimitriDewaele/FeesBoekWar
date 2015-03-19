package be.test.mavenwebapplication.business.cache;

import be.test.mavenwebapplication.entity.CountryEntity;
import be.test.mavenwebapplication.entity.CountryEntity_;
import be.test.mavenwebapplication.entity.MessageEntity;
import be.test.mavenwebapplication.entity.UserEntity;
import be.test.mavenwebapplication.entity.UserEntity_;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.persistence.Cache;
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
public class CacheService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CacheService.class);

    @PersistenceContext
    EntityManager em;

    /**
     * Creates a new instance of CacheService
     */
    public CacheService() {
    }

    public void clearCacheEntity(EntityCache entity) {
        LOGGER.debug("CLEAR CACHE for {}", entity);
        Cache cache = em.getEntityManagerFactory().getCache();
        switch (entity) {
            case USER:
                cache.evict(UserEntity.class);
                break;
            case COUNTRY:
                cache.evict(CountryEntity.class);
                break;
            case MESSAGE:
                cache.evict(MessageEntity.class);
                break;
            default:
                break;
        }
    }

    public void clearCache() {
        LOGGER.debug("CLEAR CACHE");
        Cache cache = em.getEntityManagerFactory().getCache();
        cache.evictAll();
    }
}
