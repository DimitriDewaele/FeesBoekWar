package be.feesboek.listeners;

import javax.ejb.Stateless;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Named;

@Named
@Stateless
public class PrintActionListener implements ActionListener {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PrintActionListener.class);
    
    public PrintActionListener() {
    }

    @Override
    public void processAction(ActionEvent event)
            throws AbortProcessingException {
        LOGGER.debug("Entering action listener");
        
        String current = event.getComponent().getId();
        
        //TODO: do something
    }
}
