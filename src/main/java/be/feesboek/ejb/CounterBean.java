package be.feesboek.ejb;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * CounterBean is a simple singleton session bean that records the number
 * of hits to a web page.
 * Startup: Eager initialization - initialize bean upon application startup.
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)  //Default value - can be ommited
public class CounterBean {
    private int hits = 1000;

    // Increment and return the number of hits
    @Lock(LockType.WRITE) //Default value - can be ommited
    public int getHits() {
        return hits++;
    }
}
