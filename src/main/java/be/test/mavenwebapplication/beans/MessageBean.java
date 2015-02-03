package be.test.mavenwebapplication.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author dimitridw
 */
@Named(value = "messageBean")
@SessionScoped
public class MessageBean implements Serializable {

    private String user;
    private String message;
    
    /**
     * Creates a new instance of MessageBean
     */
    public MessageBean() {
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
    
}
