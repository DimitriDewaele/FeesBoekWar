package be.feesboek.managedbeans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dimitridw
 */
@Named(value = "dialogFormBean")
@SessionScoped
public class DialogFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DialogFormBean.class);

    @NotNull
    @Size(min = 5, max = 10)
    private String field1;
    @NotNull
    @Size(min = 5, max = 10)
    private String field2;
    @NotNull
    @Size(min = 5, max = 10)
    private String field3;
    @NotNull
    @Size(min = 5, max = 10)
    private String field4;
    @NotNull
    @Size(min = 5, max = 10)
    private String field5;
    @NotNull
    @Size(min = 5, max = 10)
    private String field6;
    @NotNull
    @Size(min = 5, max = 10)
    private String field7;
    @NotNull
    @Size(min = 5, max = 10)
    private String field8;
    @NotNull
    @Size(min = 5, max = 10)
    private String field9;
    @NotNull
    @Size(min = 5, max = 10)
    private String field10;

    public DialogFormBean() {
    }

    @PostConstruct
    public void initialize() {
        LOGGER.debug("Initialize");
        field1 = "a";
        field2 = "b";
        field3 = "c";
        field4 = "d";
        field5 = "e";
        field6 = "f";
        field7 = "g";
        field8 = "h";
        field9 = "i";
        field10 = "j";
    }

    // Methods used in form
    public void preload() {
        LOGGER.debug("Method to pre-load stuff before dialog is launched");
    }

    public void nothing() {
        LOGGER.debug("Do nothing");
    }

    public void dialog1Update() {
        LOGGER.debug("Update dialog 1");
    }

    public void dialog2Update() {
        LOGGER.debug("Update dialog 2");
    }

    public void fullForm() {
        LOGGER.debug("Full form action");
    }

    // Other methods
    public String getOverviewDummyTime() {
        return "Time: " + System.currentTimeMillis();
    }

    // Getters and Setters
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

    /**
     * @return the field10
     */
    public String getField10() {
        return field10;
    }

    /**
     * @param field10 the field10 to set
     */
    public void setField10(String field10) {
        this.field10 = field10;
    }
}
