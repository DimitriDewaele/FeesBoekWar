package be.feesboek.socket;

import java.util.Date;
import java.util.Random;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
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
    private TimerService tservice;
    private Random random;
    private volatile double price = 100.0;
    private volatile int volume = 10000;

    /**
     * Creates a new instance of StockBean
     */
    public StockBean() {
        LOGGER.debug("StockBean: constructor");
    }

    @PostConstruct
    public void init() {
        /* Initialize the EJB and create a timer */
        LOGGER.debug("StockBean: PostConstruct");
        random = new Random();
        
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("StockBean timer");
        timerConfig.setPersistent(false);
        tservice.createIntervalTimer(1000, 1000, timerConfig);
    }

    @Timeout
    public void timeout(Timer timer) {
        LOGGER.trace("StockBean: timeout: {}", new Date());
        /* Adjust price and volume and send updates */
        price += 1.0 * (random.nextInt(100) - 50) / 100.0;
        volume += random.nextInt(5000) - 2500;
        StockWSEndpoint.send(price, volume);
    }

}
