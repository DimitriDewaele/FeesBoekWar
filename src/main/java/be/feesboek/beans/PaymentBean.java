package be.feesboek.beans;

import be.feesboek.event.Cash;
import be.feesboek.event.Credit;
import be.feesboek.event.Debit;
import be.feesboek.event.PaymentEvent;
import be.feesboek.interceptor.Logged;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dimitridw
 */
@Named(value = "paymentBean")
@SessionScoped
public class PaymentBean implements Serializable{
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PaymentBean.class);

    @NotNull
    private int value;
    private int option = CASH; //Default
    private Date datetime;

    private static final int CASH = 1;
    private static final int DEBIT = 2;
    private static final int CREDIT = 3;

    @Inject
    @Cash
    Event<PaymentEvent> eventCash;

    @Inject
    @Debit
    Event<PaymentEvent> eventDebit;

    @Inject
    @Credit
    Event<PaymentEvent> eventCredit;

    /**
     * Creates a new instance of PaymentBean
     */
    public PaymentBean() {
    }

    // Business Methods
    @Logged
    public String pay() {
        this.setDatetime(Calendar.getInstance().getTime());
        switch (option) {
            case CASH:
                PaymentEvent payloadCash = new PaymentEvent();
                payloadCash.setAmount(value);
                payloadCash.setType("Cash");
                payloadCash.setDatetime(datetime);
                eventCash.fire(payloadCash);
                break;
            case DEBIT:
                PaymentEvent payloadDebit = new PaymentEvent();
                payloadDebit.setAmount(value);
                payloadDebit.setType("Debit");
                payloadDebit.setDatetime(datetime);
                eventDebit.fire(payloadDebit);
                break;
            case CREDIT:
                PaymentEvent payloadCredit = new PaymentEvent();
                payloadCredit.setAmount(value);
                payloadCredit.setType("Cash");
                payloadCredit.setDatetime(datetime);
                eventCredit.fire(payloadCredit);
                break;
            default:
                LOGGER.error("Invalid payment option!");
        }
        return "/pages/observer.xhtml";
    }

    @Logged
    public void reset() {
        value = 0;
        option = CASH;
    }

    // Getters and setters
    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return the option
     */
    public int getOption() {
        return option;
    }

    /**
     * @param option the option to set
     */
    public void setOption(int option) {
        this.option = option;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
