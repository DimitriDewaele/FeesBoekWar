package be.test.mavenwebapplication.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author dimitridw
 */
@Named(value = "crazyBean")
@SessionScoped
public class CrazyBean implements Serializable {
    
    org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CrazyBean.class);
    
    private int spin = 10;
    private int count = 0;
    private boolean switcher = true;
    private int slideMin = 25;
    private int slideMax = 75;

    /**
     * Creates a new instance of CrazyForm
     */
    public CrazyBean() {
        LOGGER.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
    
    public void increment() {
        count++;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the spin
     */
    public int getSpin() {
        return spin;
    }

    /**
     * @param spin the spin to set
     */
    public void setSpin(int spin) {
        this.spin = spin;
    }

    /**
     * @return the switcher
     */
    public boolean isSwitcher() {
        return switcher;
    }

    /**
     * @param switcher the switcher to set
     */
    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }

    /**
     * @return the slideMin
     */
    public int getSlideMin() {
        return slideMin;
    }

    /**
     * @param slideMin the slideMin to set
     */
    public void setSlideMin(int slideMin) {
        this.slideMin = slideMin;
    }

    /**
     * @return the slideMax
     */
    public int getSlideMax() {
        return slideMax;
    }

    /**
     * @param slideMax the slideMax to set
     */
    public void setSlideMax(int slideMax) {
        this.slideMax = slideMax;
    }
    
}
