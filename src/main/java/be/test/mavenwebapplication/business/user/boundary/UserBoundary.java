package be.test.mavenwebapplication.business.user.boundary;

import be.test.mavenwebapplication.business.user.control.UserService;
import be.test.mavenwebapplication.entity.UserEntity;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named
@SessionScoped
public class UserBoundary implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(UserBoundary.class);
    
    @Inject
    UserService userService;
    
    public List<UserEntity> findAllByNamedQuery() {
        return userService.findAllByNamedQuery();
    }

    public List<UserEntity> findAllByBuilder() {
        return userService.findAllByBuilder();
    }

    public void save(UserEntity entity) {
        userService.save(entity);
    }

    
}