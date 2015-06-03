package be.feesboek.managedbeans;

import be.feesboek.qualifiers.MaxNumber;
import be.feesboek.qualifiers.Random;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.inject.Produces;

/**
 *
 * @author dimitridw
 */
@Named(value = "applicationGeneratorBean")
@ApplicationScoped
public class ApplicationGeneratorBean implements Serializable {
    
private static final long serialVersionUID = 1L;

    private int maxNumber = 100;

    private java.util.Random random = new java.util.Random(System.currentTimeMillis());

    java.util.Random getRandom() {
        return random;
    }

    @Produces
    @Random
    int next() {
        return getRandom().nextInt(maxNumber + 1);
    }

    @Produces
    @MaxNumber
    int getMaxNumber() {
        return maxNumber;
    }
}
