package be.test.mavenwebapplication.socket;

import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;
import javax.annotation.PostConstruct;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;

/**
 *
 * @author dimitridw
 */
@Startup
@Singleton
public class StockBean {

    public static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StockBean.class);

    /* Use the container's timer service */
    @Resource
    TimerService tservice;
    private Random random;
    private volatile double price = 100.0;
    private volatile int volume = 3000;

    /**
     * Creates a new instance of StockBean
     */
    public StockBean() {
    }

    @PostConstruct
    public void init() {
        /* Initialize the EJB and create a timer */
        LOGGER.info("Initializing EJB.");
        random = new Random();
        tservice.createIntervalTimer(1000, 1000, new TimerConfig());
    }

    @Timeout
    public void timeout() {
        /* Adjust price and volume and send updates */
        price += 1.0 * (random.nextInt(100) - 50) / 100.0;
        volume += random.nextInt(5000) - 2500;
        StockWSEndpoint.send(price, volume);
    }

}
