package be.feesboek.managedbeans;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "converterBean")
@SessionScoped
public class ConverterBean implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer field1 = 1111;
    private Integer field2 = 2222;
    private Integer field3 = 3333;
    private Integer field4 = 4444;
    private Integer field5 = 5555;
    private Integer field6 = 6666;
    private Integer field7 = 7777;
    
    private Date date1 = new Date();
    private Date date2 = new Date();
    private Date date3 = new Date();
    private Date date4 = new Date();
    private Date date5 = new Date();
    private Date date6 = new Date();
    
    private String pattern;
    
    /**
     * Creates a new instance of ConverterBean
     */
    public ConverterBean() {
    }
    
    @PostConstruct
    private void initialize() {
        pattern = "dd-MM-yyyy";
    }

    /**
     * @return the field1
     */
    public Integer getField1() {
        return field1;
    }

    /**
     * @param field1 the field1 to set
     */
    public void setField1(Integer field1) {
        this.field1 = field1;
    }

    /**
     * @return the field2
     */
    public Integer getField2() {
        return field2;
    }

    /**
     * @param field2 the field2 to set
     */
    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    /**
     * @return the field3
     */
    public Integer getField3() {
        return field3;
    }

    /**
     * @param field3 the field3 to set
     */
    public void setField3(Integer field3) {
        this.field3 = field3;
    }

    /**
     * @return the field4
     */
    public Integer getField4() {
        return field4;
    }

    /**
     * @param field4 the field4 to set
     */
    public void setField4(Integer field4) {
        this.field4 = field4;
    }

    /**
     * @return the field5
     */
    public Integer getField5() {
        return field5;
    }

    /**
     * @param field5 the field5 to set
     */
    public void setField5(Integer field5) {
        this.field5 = field5;
    }

    /**
     * @return the field6
     */
    public Integer getField6() {
        return field6;
    }

    /**
     * @param field6 the field6 to set
     */
    public void setField6(Integer field6) {
        this.field6 = field6;
    }

    /**
     * @return the date1
     */
    public Date getDate1() {
        return date1;
    }

    /**
     * @param date1 the date1 to set
     */
    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    /**
     * @return the date2
     */
    public Date getDate2() {
        return date2;
    }

    /**
     * @param date2 the date2 to set
     */
    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    /**
     * @return the date3
     */
    public Date getDate3() {
        return date3;
    }

    /**
     * @param date3 the date3 to set
     */
    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    /**
     * @return the date4
     */
    public Date getDate4() {
        return date4;
    }

    /**
     * @param date4 the date4 to set
     */
    public void setDate4(Date date4) {
        this.date4 = date4;
    }

    /**
     * @return the date5
     */
    public Date getDate5() {
        return date5;
    }

    /**
     * @param date5 the date5 to set
     */
    public void setDate5(Date date5) {
        this.date5 = date5;
    }

    /**
     * @return the date6
     */
    public Date getDate6() {
        return date6;
    }

    /**
     * @param date6 the date6 to set
     */
    public void setDate6(Date date6) {
        this.date6 = date6;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return the field7
     */
    public Integer getField7() {
        return field7;
    }

    /**
     * @param field7 the field7 to set
     */
    public void setField7(Integer field7) {
        this.field7 = field7;
    }

}
