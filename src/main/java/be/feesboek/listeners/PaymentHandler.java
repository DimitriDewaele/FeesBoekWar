package be.feesboek.listeners;

import be.feesboek.qualifiers.Cash;
import be.feesboek.qualifiers.Credit;
import be.feesboek.qualifiers.Debit;
import be.feesboek.event.PaymentEvent;
import be.feesboek.interceptor.Logged;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

/**
 * Handler for the two kinds of PaymentEvent.
 */
@Logged
@SessionScoped
public class PaymentHandler implements Serializable {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PaymentHandler.class);
    private static final long serialVersionUID = 2013564481486393525L;

    public PaymentHandler() {
        LOGGER.info("PaymentHandler created.");
    }

    public void cashPayment(@Observes @Cash PaymentEvent event) {
        LOGGER.info("PaymentHandler - Cash Handler: {}", event.toString());

        // call a specific Cash handler class...
        // Business code that would perform the Cash payment
    }

    public void creditPayment(@Observes @Credit PaymentEvent event) {
        LOGGER.info("PaymentHandler - Credit Handler: {}", event.toString());

        // call a specific Credit handler class...
        // Business code that would perform the Credit payment
    }

    public void debitPayment(@Observes @Debit PaymentEvent event) {
        LOGGER.info("PaymentHandler - Debit Handler: {}", event.toString());

        // call a specific Debit handler class...
        // Business code that would perform the Debit payment
    }
}
