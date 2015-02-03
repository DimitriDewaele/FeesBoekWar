package be.test.mavenwebapplication.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author dimitridw
 */
@Named(value = "crazyForm")
@SessionScoped
public class CrazyForm implements Serializable {
    
    private int count;

    /**
     * Creates a new instance of CrazyForm
     */
    public CrazyForm() {
    }
    
    public void increment() {
        count++;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    
}
