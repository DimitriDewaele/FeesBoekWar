package be.test.feesboek.interceptor;

import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Logged
@Interceptor
public class LoggedInterceptor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoggedInterceptor.class);

    public LoggedInterceptor() {
    }

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext)
            throws Exception {
        
        LOGGER.debug("Entering method: "
                + invocationContext.getMethod().getName() + " in class "
                + invocationContext.getMethod().getDeclaringClass().getName());

        return invocationContext.proceed();
    }
}
