package be.test.mavenwebapplication.beans;

import be.test.mavenwebapplication.business.country.boundary.CountryBoundary;
import be.test.mavenwebapplication.business.message.boundary.MessageBoundary;
import be.test.mavenwebapplication.business.user.boundary.UserBoundary;
import be.test.mavenwebapplication.entity.CountryEntity;
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

    private Long userId;
    private String username;
    private String firstname;
    private String lastname;
    private CountryEntity country;
    
    private String first;
    private MessageEntity message;

    private List<MessageEntity> messages1;
    private List<MessageEntity> messages2;
    private List<MessageEntity> messages3;

    private List<UserEntity> users1;
    private List<UserEntity> users2;
    private List<UserEntity> users3;
    
    private List<CountryEntity> countries;

    @Inject
    CountryBoundary countryBoundary;
    @Inject
    UserBoundary userBoundary;
    @Inject
    MessageBoundary messageBoundary;

    PersistenceBean() {
    }

    @PostConstruct
    public void postConstruct() {
        LOGGER.trace("MessageBean PostConstruct");
        
        countries = countryBoundary.findAllByBuilder();
        
        setMessages1(messageBoundary.findAllByNamedQuery());
        setMessages2(messageBoundary.findAllByBuilder());
        setMessages3(messageBoundary.findAllByBuilder());
        
        setUsers1(userBoundary.findAllByNamedQuery());
        setUsers2(userBoundary.findAllByBuilder());
        setUsers3(userBoundary.findAllByBuilder());

        setMessage(messageBoundary.findByFetchGraph(1L));
    }
    
    public String createUser() {
        LOGGER.debug("Create User: {}", username);
        
        UserEntity user = new UserEntity();
        user.setUserId(userId);
        user.setUsername(username);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setCountryId(country);
        
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
     * @return the countries
     */
    public List<CountryEntity> getCountries() {
        return countries;
    }

    /**
     * @param countries the countries to set
     */
    public void setCountries(List<CountryEntity> countries) {
        this.countries = countries;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

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
