package be.feesboek.managedbeans;

import be.feesboek.qualifiers.Official;
import javax.enterprise.context.Dependent;

@Dependent
@Official
public class GreetingOfficial extends Greeting{
    
    @Override
    public String greet(String name) {
        return "Official: Dear Mr/Mss " + name + ". Have a pleasant day.";
    }
}
