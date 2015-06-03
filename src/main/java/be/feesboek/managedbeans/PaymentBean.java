package be.feesboek.managedbeans;

import be.feesboek.qualifiers.Cash;
import be.feesboek.qualifiers.Credit;
import be.feesboek.qualifiers.Debit;
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
public class PaymentBean implements Serializable {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PaymentBean.class);

    @NotNull
    private int value;
    private int option = CASH; //Default
    private Date datetime;

    private static final int CASH = 1;
    private static final int DEBIT = 2;
    private static final int CREDIT = 3;

    // Use a qualifier to differentiate between the different payment events
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

    // Depending on the input, fire a correct event.
    // An event listener (PaymentHandler.java) handles the event, using observer methods, and performs business logic.
    // @Logged: intercepter to log stuff
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
        return "/pages/cdi/observer.xhtml";
    }

    @Logged
    public void reset() {
        value = 0;
        option = CASH;
    }

    public String showType() {
        String output = "nothing";
        switch (option) {
            case CASH:
                output = "Cash";
                break;
            case DEBIT:
                output = "Debit";
                break;
            case CREDIT:
                output = "Credit";
                break;
            default:
                LOGGER.error("Invalid payment option!");
        }
        return output;
    }

    // Getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getOption() {
        return option;
    }

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
