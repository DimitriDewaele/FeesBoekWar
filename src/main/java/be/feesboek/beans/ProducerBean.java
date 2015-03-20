package be.feesboek.beans;

import be.feesboek.business.Chosen;
import be.feesboek.business.Producer;
import be.feesboek.business.ProducerImplBin;
import be.feesboek.business.ProducerImplDec;
import be.feesboek.business.ProducerImplHex;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dimitridw
 */
@Named(value = "producerBean")
@RequestScoped
public class ProducerBean {

    @Min(0)
    @NotNull
    private int input;
    private String output;

    private int type = DECIMAL; //Default

    private static final int DECIMAL = 1;
    private static final int BINARY = 2;
    private static final int HEXA = 3;

    // Inject the choosen producer implementation for doing the business.
    @Inject
    @Chosen
    @RequestScoped
    private Producer producer;

    /**
     * Creates a new instance of ProducerBean
     */
    public ProducerBean() {
    }

    // method that produces a choosen producer.
    @Produces
    @Chosen
    @RequestScoped
    public Producer chooseProducer() {
        switch (type) {
            case BINARY:
                return new ProducerImplBin();
            case HEXA:
                return new ProducerImplHex();
            case DECIMAL:
            default:
                return new ProducerImplDec();
        }
    }

    // Business Methods
    public void encodeInput() {
        setOutput(producer.produceNumber(input));
    }

    public void reset() {
        setInput(0);
    }

    // Getters and Setters
    /**
     * @return the input
     */
    public int getInput() {
        return input;
    }

    /**
     * @param input the input to set
     */
    public void setInput(int input) {
        this.input = input;
    }

    /**
     * @return the output
     */
    public String getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(String output) {
        this.output = output;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

}
