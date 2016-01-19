package be.feesboek.managedbeans;

import be.feesboek.ejb.CounterBean;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author dimitridw
 */
@Named(value = "applicationBean")
@ApplicationScoped
public class ApplicationBean {
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ApplicationBean.class);
    
    private Date start;

    //Use Singleton EJB to count - demonstration purposes
    @EJB
    private CounterBean counterBean;

    /**
     * Creates a new instance of ApplicationBean
     */
    public ApplicationBean() {
    }
    
    @PostConstruct
    public void postConstruct() {
        LOGGER.debug("ApplicationBean: PostConstruct");
        start = new Date();
        //count = 1;
    }
    
    @PreDestroy
    public void preDestroy() {
        LOGGER.debug("ApplicationBean: PreDestroy");
    }
    
    public int counter() {
        //Application counter
        return counterBean.getHits();
    }

    /**
     * @return the start
     */
    public Date getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Date start) {
        this.start = start;
    }    
}
