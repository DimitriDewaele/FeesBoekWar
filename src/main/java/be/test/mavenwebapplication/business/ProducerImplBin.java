package be.test.mavenwebapplication.business;

/**
 *
 * @author dimitridw
 */
public class ProducerImplBin implements Producer {

    @Override
    public String produceNumber(int number) {
        return Integer.toBinaryString(number);
    }
    
}
