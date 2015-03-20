package be.test.feesboek.business.cache;

import be.test.feesboek.entity.CountryEntity;
import be.test.feesboek.entity.MessageEntity;
import be.test.feesboek.entity.UserEntity;
import javax.ejb.Stateless;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
