package be.feesboek.listeners;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.inject.Named;

@Named
@Stateless
public class NameChanged extends Object implements ValueChangeListener {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(NameChanged.class);

    @Override
    public void processValueChange(ValueChangeEvent event)
            throws AbortProcessingException {
        LOGGER.debug("Entering NameChanged.processValueChange");
        if (null != event.getNewValue()) {
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put("name", event.getNewValue());
            //Do some other stuff
        }
    }
}
