package be.feesboek.business;

public class CoderImpl implements Coder {

    @Override
    public String codeString(String input, int codeNumber) {
        return "Code " + codeNumber + " " + input;
    }
    
}
