package be.feesboek.socket;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author dimitridw There is a StockWSEndpoint instance per connection
 */
@ServerEndpoint("/stockWSEndPoint")
public class StockWSEndpoint {
    
    private static String color = "white";

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StockWSEndpoint.class);

    /* Queue for all open WebSocket sessions */
    static Queue<Session> queue = new ConcurrentLinkedQueue<>();

    /* PriceVolumeBean calls this method to send updates */
    public static void send(double price, int volume) {
        String msg = String.format("%.2f / %d / %s", price, volume, color);
        try {
            /* Send updates to all open WebSocket sessions */
            for (Session session : queue) {
                session.getBasicRemote().sendText(msg);
                LOGGER.info("Sent: {}", msg);
            }
        } catch (IOException e) {
            LOGGER.info(e.toString());
        }
    }

    /* Not used in this setup - client only reads data, does not send */
    @OnMessage
    public void onMessage(String color) {
        this.color = color;
        LOGGER.info("Message received: color = {}", color);
    }

    @OnOpen
    public void openConnection(Session session) {
        /* Register this connection in the queue */
        queue.add(session);
        LOGGER.info("Connection opened.");
    }

    @OnClose
    public void closedConnection(Session session) {
        /* Remove this connection from the queue */
        queue.remove(session);
        LOGGER.info("Connection closed.");
    }

    @OnError
    public void error(Session session, Throwable t) {
        /* Remove this connection from the queue */
        queue.remove(session);
        LOGGER.info(t.toString());
        LOGGER.info("Connection error.");
    }

}
