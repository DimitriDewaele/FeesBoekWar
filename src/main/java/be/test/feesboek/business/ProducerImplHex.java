package be.test.feesboek.business;

/**
 *
 * @author dimitridw
 */
public class ProducerImplHex implements Producer {

    @Override
    public String produceNumber(int number) {
        return Integer.toString(number, 16);
    }
    
}
