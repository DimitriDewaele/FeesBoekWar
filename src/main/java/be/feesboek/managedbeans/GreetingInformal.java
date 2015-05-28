package be.feesboek.managedbeans;

import be.feesboek.qualifiers.Informal;
import javax.enterprise.context.Dependent;

@Dependent
@Informal
public class GreetingInformal extends Greeting{
    
    @Override
    public String greet(String name) {
        return "Informal: " + name + ", how are you today?";
    }
}
