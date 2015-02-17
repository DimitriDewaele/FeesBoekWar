package be.test.mavenwebapplication.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;

/**
 *
 * @author dimitridw
 */
@Named(value = "messageBean")
@SessionScoped
public class MessageBean implements Serializable {

    private String user;
    private String message;
    private Integer age;
    private Date lastFriday;
    private double price;
    /**
     * Creates a new instance of MessageBean
     */
    public MessageBean() {
    }

    @PostConstruct
    public void init() {
        lastFriday = new Date();
        price = 54.31;
    }
            
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the lastFriday
     */
    public Date getLastFriday() {
        return lastFriday;
    }

    /**
     * @param lastFriday the lastFriday to set
     */
    public void setLastFriday(Date lastFriday) {
        this.lastFriday = lastFriday;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
}
