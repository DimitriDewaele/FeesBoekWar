package be.feesboek.webmessage;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;

@JMSDestinationDefinition(
        name = "java:comp/jms/printQueue",
        interfaceName = "javax.jms.Queue",
        destinationName = "PhysicalPrintQueue")
@Named(value = "printManagedBean")
@Dependent
public class PrintManagedBean {

    static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PrintManagedBean.class);

    @Inject
    private JMSContext context;
    @Resource(lookup = "java:comp/jms/printQueue")
    private Queue queue;

    /**
     * Creates a new instance of PrintManagedBean
     */
    public PrintManagedBean() {
    }

    public void sendMessage(String printer) {
        try {
            String text = "Message for printer: " + printer;

            Message message = context.createTextMessage(text);
            message.setStringProperty("Printer", printer);

            context.createProducer().send(queue, message);

            LOGGER.debug("Sending message: " + text);
            FacesMessage facesMessage = new FacesMessage("Sending message: " + text);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } catch (Exception ex) {
            LOGGER.error("SenderBean.sendMessage: Exception: {}", ex.toString());
        }
    }

    public void getMessage(String printer) {
        try {
            String messageSelector = "Printer = '" + printer + "'";
            JMSConsumer receiver = context.createConsumer(queue, messageSelector);
            //String text = receiver.receiveBody(String.class, 1000);
            String text = receiver.receiveBodyNoWait(String.class);

            if (text != null) {
                LOGGER.debug("Reading message: " + text);
                FacesMessage facesMessage = new FacesMessage("Reading message: " + text);
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            } else {
                LOGGER.debug("No message received after 1 second");
                FacesMessage facesMessage = new FacesMessage("No message received after 1 second");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }
        } catch (Exception ex) {
            LOGGER.error("SenderBean.sendMessage: Exception: {}", ex.toString());
        }
    }

    public void getMessageById(String id) {
        try {
            String messageSelector = "JMSMessageID = '" + id + "'";
            JMSConsumer receiver = context.createConsumer(queue, messageSelector);
            //String text = receiver.receiveBody(String.class, 1000);
            String text = receiver.receiveBodyNoWait(String.class);

            if (text != null) {
                LOGGER.debug("Reading message: " + text);
                FacesMessage facesMessage = new FacesMessage("Reading message: " + text);
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            } else {
                LOGGER.debug("No message received after 1 second");
                FacesMessage facesMessage = new FacesMessage("No message received after 1 second");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }
        } catch (Exception ex) {
            LOGGER.error("SenderBean.sendMessage: Exception: {}", ex.toString());
        }
    }

    public void getLongMessage() {
        try {
            JMSConsumer receiver = context.createConsumer(queue);
            String text = receiver.receiveBody(String.class, 10000);

            if (text != null) {
                LOGGER.debug("Reading message: " + text);
                FacesMessage facesMessage = new FacesMessage("Reading message: " + text);
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            } else {
                LOGGER.debug("No message received after 5 second");
                FacesMessage facesMessage = new FacesMessage("No message received after 5 second");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }
        } catch (Exception ex) {
            LOGGER.error("SenderBean.sendMessage: Exception: {}", ex.toString());
        }
    }

    public List<MessageVO> getList() {
        List<MessageVO> messageList = new ArrayList<>();

        try {
            LOGGER.debug("Browse queue");
            QueueBrowser browser = context.createBrowser(queue);
            Enumeration msgs = browser.getEnumeration();

            if (!msgs.hasMoreElements()) {
                MessageVO empty = new MessageVO();
                empty.setId("");
                empty.setBody("No messages in queue");
                empty.setProperty("");
            } else {
                while (msgs.hasMoreElements()) {
                    Message temp = (Message) msgs.nextElement();

                    String id = temp.getJMSMessageID();
                    String body = temp.getBody(String.class);
                    String prop = temp.getStringProperty("Printer");

                    MessageVO messageVO = new MessageVO();
                    messageVO.setId(id);
                    messageVO.setBody(body);
                    messageVO.setProperty(prop);

                    messageList.add(messageVO);
                }
            }
        } catch (Exception ex) {
            LOGGER.error("SenderBean.sendMessage: Exception: {}", ex.toString());
        }

        return messageList;
    }
}
