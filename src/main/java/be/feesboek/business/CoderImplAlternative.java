package be.feesboek.business;

import javax.enterprise.inject.Alternative;

@Alternative
public class CoderImplAlternative implements Coder {

    @Override
    public String codeString(String input, int codeNumber) {
        return "Alternative: Code " + codeNumber + " " + input;
    }
    
}
