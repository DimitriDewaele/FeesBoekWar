package be.test.feesboek.beans;

import be.test.feesboek.business.Coder;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dimitridw
 */
@Named(value = "coderBean")
@RequestScoped
public class CoderBean {

    private String inputString;
    private String codedString;
    @Max(10)
    @Min(0)
    @NotNull
    private int codeNumber;
    @Inject
    private Coder coder;

    /**
     * Creates a new instance of CoderBean
     */
    public CoderBean() {
    }

    // Business Methods
    public void encodeString() {
        setCodedString(coder.codeString(inputString, codeNumber));
    }

    public void reset() {
        setInputString("");
        setCodeNumber(0);
    }
    
    // Getters and Setters

    /**
     * @return the inputString
     */
    public String getInputString() {
        return inputString;
    }

    /**
     * @param inputString the inputString to set
     */
    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    /**
     * @return the codedString
     */
    public String getCodedString() {
        return codedString;
    }

    /**
     * @param codedString the codedString to set
     */
    public void setCodedString(String codedString) {
        this.codedString = codedString;
    }

    /**
     * @return the codeNumber
     */
    public int getCodeNumber() {
        return codeNumber;
    }

    /**
     * @param codeNumber the codeNumber to set
     */
    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }

}
