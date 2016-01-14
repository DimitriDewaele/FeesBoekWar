package be.feesboek.managedbeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

@Named(value = "dateTimeBean")
@RequestScoped
public class DateTimeBean {

    private Date datetime1;
    private Date datetime2;
    private DateTime datetime3;
    
    private Date dateNoTime1;
    private Date dateNoTime2;
    private LocalDate dateNoTime3;
    
    private DateTime jodaDateTime;
    private LocalDate jodaDate;
    private LocalTime jodaTime;

    /**
     * Creates a new instance of DateTimeBean
     */
    public DateTimeBean() {
    }

    @PostConstruct
    public void initialize() {
        // Date and time
        datetime1 = new Date();
        datetime2 = new Date();
        datetime3 = new DateTime();
        
        // Date without time
        // Problem with Date: always has a particular time

        // method 1
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateNoTime1 = sdf.parse(sdf.format(new Date()));
        } catch (ParseException ex) {
            Logger.getLogger(DateTimeBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        // method 2
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        dateNoTime2 = cal.getTime();
        
        // method 3: Use the Joda library.
        // Try to avoid 3rd party libraries for simple tasks, but this one is extremely popular
        // Joda does know a concept of date without time: LocalDate
        dateNoTime3 = new LocalDate();
        
        // Work with joda time
        jodaDateTime = new DateTime();
        
        jodaDate = new LocalDate();
        
        jodaTime = new LocalTime();
    }
    
    public String showMonth(){
        return jodaDateTime.monthOfYear().getAsShortText(Locale.FRENCH);
    }

    public DateTime showYear(int year){
        return jodaDateTime.withYear(year);
    }

    /**
     * @return the datetime1
     */
    public Date getDatetime1() {
        return datetime1;
    }

    /**
     * @param datetime1 the datetime1 to set
     */
    public void setDatetime1(Date datetime1) {
        this.datetime1 = datetime1;
    }

    /**
     * @return the datetime2
     */
    public Date getDatetime2() {
        return datetime2;
    }

    /**
     * @param datetime2 the datetime2 to set
     */
    public void setDatetime2(Date datetime2) {
        this.datetime2 = datetime2;
    }

    /**
     * @return the datetime3
     */
    public DateTime getDatetime3() {
        return datetime3;
    }

    /**
     * @param datetime3 the datetime3 to set
     */
    public void setDatetime3(DateTime datetime3) {
        this.datetime3 = datetime3;
    }

    /**
     * @return the dateNoTime1
     */
    public Date getDateNoTime1() {
        return dateNoTime1;
    }

    /**
     * @param dateNoTime1 the dateNoTime1 to set
     */
    public void setDateNoTime1(Date dateNoTime1) {
        this.dateNoTime1 = dateNoTime1;
    }

    /**
     * @return the dateNoTime2
     */
    public Date getDateNoTime2() {
        return dateNoTime2;
    }

    /**
     * @param dateNoTime2 the dateNoTime2 to set
     */
    public void setDateNoTime2(Date dateNoTime2) {
        this.dateNoTime2 = dateNoTime2;
    }

    /**
     * @return the dateNoTime3
     */
    public LocalDate getDateNoTime3() {
        return dateNoTime3;
    }

    /**
     * @param dateNoTime3 the dateNoTime3 to set
     */
    public void setDateNoTime3(LocalDate dateNoTime3) {
        this.dateNoTime3 = dateNoTime3;
    }

    /**
     * @return the jodaTime
     */
    public DateTime getJodaDateTime() {
        return jodaDateTime;
    }

    /**
     * @param jodaTime the jodaTime to set
     */
    public void setJodaDateTime(DateTime jodaTime) {
        this.jodaDateTime = jodaTime;
    }

    /**
     * @return the jodaDate
     */
    public LocalDate getJodaDate() {
        return jodaDate;
    }

    /**
     * @param jodaDate the jodaDate to set
     */
    public void setJodaDate(LocalDate jodaDate) {
        this.jodaDate = jodaDate;
    }

    /**
     * @return the jodaTime
     */
    public LocalTime getJodaTime() {
        return jodaTime;
    }

    /**
     * @param jodaTime the jodaTime to set
     */
    public void setJodaTime(LocalTime jodaTime) {
        this.jodaTime = jodaTime;
    }

}
