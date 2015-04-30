package be.feesboek.listeners;

import be.feesboek.event.Cash;
import be.feesboek.event.Credit;
import be.feesboek.event.Debit;
import be.feesboek.event.PaymentEvent;
import be.feesboek.interceptor.Logged;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

/**
 *
 * @author dimitridw
 */
@Logged
@Named(value = "paymentHandler")
@SessionScoped
public class PaymentHandler implements Serializable {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PaymentHandler.class);

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of PaymentHandler
     */
    public PaymentHandler() {
    }

    //Annotate with Observes and with the qualifier
    public void paymentWithCash(@Observes @Cash PaymentEvent event) {
        LOGGER.debug("Payment with Cash");
        //Do something with the cash
    }

    public void paymentWithDebit(@Observes @Debit PaymentEvent event) {
        LOGGER.debug("Payment with Debit Card");
        //Debit the debit card
    }

    public void paymentWithCredit(@Observes @Credit PaymentEvent event) {
        LOGGER.debug("Payment with Credit Card");
        //Debit the credit card
    }
}
