package be.feesboek.managedbeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "listenerBean")
@SessionScoped
public class ListenerBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of ListenerBean
     */
    public ListenerBean() {
    }
    
}
