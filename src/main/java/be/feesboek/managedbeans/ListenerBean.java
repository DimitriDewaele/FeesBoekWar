package be.feesboek.managedbeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author dimitridw
 */
@Named(value = "listenerBean")
@SessionScoped
public class ListenerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ListenerBean.class);

    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;

    /**
     * Creates a new instance of ListenerBean
     */
    public ListenerBean() {
    }

    public void valueChanged(ValueChangeEvent e) {
        //Only called when the form is submitted.
        LOGGER.debug("Entering the value change listener");
        //Do something in the bean
        field3 = field3 + "-added";
    }

    public void printIt(ActionEvent event) {
        //Action Listener to handle an action event.
        // !! not an Action (for navigation)
        LOGGER.debug("Entering the pintIt action listener");
        //Get submit button id
        String buttonId = event.getComponent().getClientId();
        //TODO: do something with this.

    }

    public String outcome() {
        //Action method used for navigation: return a string
        return "listeners";
    }

    /**
     * @return the field1
     */
    public String getField1() {
        return field1;
    }

    /**
     * @param field1 the field1 to set
     */
    public void setField1(String field1) {
        this.field1 = field1;
    }

    /**
     * @return the field2
     */
    public String getField2() {
        return field2;
    }

    /**
     * @param field2 the field2 to set
     */
    public void setField2(String field2) {
        this.field2 = field2;
    }

    /**
     * @return the field3
     */
    public String getField3() {
        return field3;
    }

    /**
     * @param field3 the field3 to set
     */
    public void setField3(String field3) {
        this.field3 = field3;
    }

    /**
     * @return the field4
     */
    public String getField4() {
        return field4;
    }

    /**
     * @param field4 the field4 to set
     */
    public void setField4(String field4) {
        this.field4 = field4;
    }

    /**
     * @return the field5
     */
    public String getField5() {
        return field5;
    }

    /**
     * @param field5 the field5 to set
     */
    public void setField5(String field5) {
        this.field5 = field5;
    }

    /**
     * @return the field6
     */
    public String getField6() {
        return field6;
    }

    /**
     * @param field6 the field6 to set
     */
    public void setField6(String field6) {
        this.field6 = field6;
    }

}
