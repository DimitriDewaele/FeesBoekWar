package be.test.feesboek.business.cache;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author dimitridw
 */
@Named
@SessionScoped
public class CacheBoundary implements Serializable {

    private static final long serialVersionUID = 1L;

    org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CacheBoundary.class);

    @Inject
    CacheService cacheService;

    /**
     * Creates a new instance of CacheBoundary
     */
    public CacheBoundary() {
    }
    
    public void clearCacheEntity(EntityCache entity) {
        cacheService.clearCacheEntity(entity);
    }

    public void clearCache() {
        cacheService.clearCache();
    }

}
