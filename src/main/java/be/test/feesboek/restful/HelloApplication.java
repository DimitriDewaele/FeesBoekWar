package be.test.feesboek.restful;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Class to define the JAX-RS application
 * This can also be set without this class, but in the web.xml
 */
@ApplicationPath("/restful")
public class HelloApplication extends Application {

}
