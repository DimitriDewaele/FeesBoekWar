package be.feesboek.managedbeans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dimitridw
 */
@Named(value = "validatorBean")
@SessionScoped
public class ValidatorBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long field1 = 1111L;
    private Long field2 = 2222L;
    @Min(1000)
    private Long field3 = 3333L;
    private Long field4 = 4444L;
    private Long field5 = 5555L;
    private Long field6 = 6666L;
    private Long field7 = 7777L;
    private Long field8 = 8888L;
    private Long field9 = 9999L;
    

    /**
     * Creates a new instance of ValidatorBean
     */
    public ValidatorBean() {
    }

    /**
     * @return the field1
     */
    public Long getField1() {
        return field1;
    }

    /**
     * @param field1 the field1 to set
     */
    public void setField1(Long field1) {
        this.field1 = field1;
    }

    /**
     * @return the field2
     */
    public Long getField2() {
        return field2;
    }

    /**
     * @param field2 the field2 to set
     */
    public void setField2(Long field2) {
        this.field2 = field2;
    }

    /**
     * @return the field3
     */
    public Long getField3() {
        return field3;
    }

    /**
     * @param field3 the field3 to set
     */
    public void setField3(Long field3) {
        this.field3 = field3;
    }

    /**
     * @return the field4
     */
    public Long getField4() {
        return field4;
    }

    /**
     * @param field4 the field4 to set
     */
    public void setField4(Long field4) {
        this.field4 = field4;
    }

    /**
     * @return the field5
     */
    public Long getField5() {
        return field5;
    }

    /**
     * @param field5 the field5 to set
     */
    public void setField5(Long field5) {
        this.field5 = field5;
    }

    /**
     * @return the field6
     */
    public Long getField6() {
        return field6;
    }

    /**
     * @param field6 the field6 to set
     */
    public void setField6(Long field6) {
        this.field6 = field6;
    }

    /**
     * @return the field7
     */
    public Long getField7() {
        return field7;
    }

    /**
     * @param field7 the field7 to set
     */
    public void setField7(Long field7) {
        this.field7 = field7;
    }

    /**
     * @return the field8
     */
    public Long getField8() {
        return field8;
    }

    /**
     * @param field8 the field8 to set
     */
    public void setField8(Long field8) {
        this.field8 = field8;
    }

    /**
     * @return the field9
     */
    public Long getField9() {
        return field9;
    }

    /**
     * @param field9 the field9 to set
     */
    public void setField9(Long field9) {
        this.field9 = field9;
    }
}
