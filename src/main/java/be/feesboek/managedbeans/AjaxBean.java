package be.feesboek.managedbeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "ajaxBean")
@SessionScoped
public class AjaxBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(AjaxBean.class);
    
    private String field1 = "aaaaa";
    private String field2 = "bbbbb";
    private String field3 = "ccccc";
    private String field4 = "ddddd";
    private String field5 = "eeeee";
    private String field6 = "fffff";
    private String field7 = "ggggg";
    private String field8 = "hhhhh";
    private String field9 = "iiiii";
    
    /**
     * Creates a new instance of AjaxBean
     */
    public AjaxBean() {
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

    /**
     * @return the field7
     */
    public String getField7() {
        return field7;
    }

    /**
     * @param field7 the field7 to set
     */
    public void setField7(String field7) {
        this.field7 = field7;
    }

    /**
     * @return the field8
     */
    public String getField8() {
        return field8;
    }

    /**
     * @param field8 the field8 to set
     */
    public void setField8(String field8) {
        this.field8 = field8;
    }

    /**
     * @return the field9
     */
    public String getField9() {
        return field9;
    }

    /**
     * @param field9 the field9 to set
     */
    public void setField9(String field9) {
        this.field9 = field9;
    }
    
}
