package be.test.feesboek.business;

import javax.enterprise.inject.Alternative;

/**
 *
 * @author dimitridw
 */
@Alternative
public class CoderImplAlternative implements Coder {

    @Override
    public String codeString(String input, int codeNumber) {
        return "Alternative: Code " + codeNumber + " " + input;
    }
    
}
