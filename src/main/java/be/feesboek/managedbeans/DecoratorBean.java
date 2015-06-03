package be.feesboek.managedbeans;

import be.feesboek.interceptor.Logged;
import be.feesboek.workers.Worker;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "decoratorBean")
@RequestScoped
public class DecoratorBean {
    
    private String input;
    private String output;
    
    @Inject
    Worker worker;
    
    public DecoratorBean() {
    }

    // Methods
    @Logged
    public void encode() {
        output = worker.transform(input);
    }
    
    // Getters and Setters
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

}
