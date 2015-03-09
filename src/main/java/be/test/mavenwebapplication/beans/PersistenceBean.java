package be.test.mavenwebapplication.beans;

import be.test.mavenwebapplication.business.message.boundary.MessageBoundary;
import be.test.mavenwebapplication.business.user.boundary.UserBoundary;
import be.test.mavenwebapplication.entity.MessageEntity;
import be.test.mavenwebapplication.entity.UserEntity;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named
@SessionScoped
public class PersistenceBean implements Serializable {

    private static final Long serialVersionUID = 1L;

    org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageBoundary.class);

    private String UserName;
    
    private String first;
    private MessageEntity message;

    private List<MessageEntity> messages1;
    private List<MessageEntity> messages2;
    private List<MessageEntity> messages3;

    private List<UserEntity> users1;
    private List<UserEntity> users2;
    private List<UserEntity> users3;

    @Inject
    MessageBoundary messageBoundary;
    @Inject
    UserBoundary userBoundary;

    PersistenceBean() {
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.trace("MessageBean PostConstruct");
        setMessages1(messageBoundary.findAllByNamedQuery());
        setMessages2(messageBoundary.findAllByBuilder());
        setMessages3(messageBoundary.findAllByBuilder());
        
        setUsers1(userBoundary.findAllByNamedQuery());
        setUsers2(userBoundary.findAllByBuilder());
        setUsers3(userBoundary.findAllByBuilder());

        setMessage(messageBoundary.findByFetchGraph(1L));
    }
    
    public String createUser() {
        LOGGER.debug("Create User: {}", UserName);
        
        UserEntity user = new UserEntity();
        user.setName(UserName);
        //TODO: get max or let to be generated in db
        user.setId(4L);
        
        userBoundary.save(user);
        
        return "";
    }
    
    //Getters and Setters

    /**
     * @return the first
     */
    public String getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * @return the message
     */
    public MessageEntity getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    /**
     * @return the messages1
     */
    public List<MessageEntity> getMessages1() {
        return messages1;
    }

    /**
     * @param messages1 the messages1 to set
     */
    public void setMessages1(List<MessageEntity> messages1) {
        this.messages1 = messages1;
    }

    /**
     * @return the messages2
     */
    public List<MessageEntity> getMessages2() {
        return messages2;
    }

    /**
     * @param messages2 the messages2 to set
     */
    public void setMessages2(List<MessageEntity> messages2) {
        this.messages2 = messages2;
    }

    /**
     * @return the messages3
     */
    public List<MessageEntity> getMessages3() {
        return messages3;
    }

    /**
     * @param messages3 the messages3 to set
     */
    public void setMessages3(List<MessageEntity> messages3) {
        this.messages3 = messages3;
    }

    /**
     * @return the users1
     */
    public List<UserEntity> getUsers1() {
        return users1;
    }

    /**
     * @param users1 the users1 to set
     */
    public void setUsers1(List<UserEntity> users1) {
        this.users1 = users1;
    }

    /**
     * @return the users2
     */
    public List<UserEntity> getUsers2() {
        return users2;
    }

    /**
     * @param users2 the users2 to set
     */
    public void setUsers2(List<UserEntity> users2) {
        this.users2 = users2;
    }

    /**
     * @return the users3
     */
    public List<UserEntity> getUsers3() {
        return users3;
    }

    /**
     * @param users3 the users3 to set
     */
    public void setUsers3(List<UserEntity> users3) {
        this.users3 = users3;
    }

    /**
     * @return the UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
}
