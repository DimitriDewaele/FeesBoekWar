package be.feesboek.managedbeans;

import be.feesboek.qualifiers.MaxNumber;
import be.feesboek.qualifiers.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author dimitridw
 */
@Named(value = "producerSimpleBean")
@RequestScoped
public class ProducerSimpleBean {

    @Inject
    @MaxNumber
    private int maxNumber;
    
    @Inject
    @Random
    private int randomNumber;

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

}
