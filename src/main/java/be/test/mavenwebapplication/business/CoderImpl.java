package be.test.mavenwebapplication.business;

/**
 *
 * @author dimitridw
 */
public class CoderImpl implements Coder {

    @Override
    public String codeString(String input, int codeNumber) {
        return "Code " + codeNumber + " " + input;
    }
    
}
