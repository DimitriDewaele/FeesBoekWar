package be.test.mavenwebapplication.event;

import be.test.mavenwebapplication.interceptor.Logged;
import java.util.Date;

/**
 *
 * @author dimitridw
 */
@Logged
public class PaymentEvent {
    
    private int amount;
    private String type;
    private Date datetime;

    /**
     * Creates a new instance of PaymentBean
     */
    public PaymentEvent() {
    }
    
    @Override
    public String toString(){
        return "Paying " + getAmount() + " with " + getType() + " on " + getDatetime().toString();
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the datetime
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * @param datetime the datetime to set
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
    
}
