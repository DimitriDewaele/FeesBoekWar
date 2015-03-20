package be.feesboek.gridform.element;

import org.primefaces.component.message.Message;

/**
 *
 * @author dimitridw
 */
public class MyPrimeMessage {

    public MyPrimeMessage() {
    }

    public static Message generate(String messageFor) {

        Message element = new Message();
        element.setFor(messageFor);

        return element;
    }
}
