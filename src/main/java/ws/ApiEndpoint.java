package ws;

import com.owlike.genson.Genson;
import dto.hateoas.TweetDTO;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.*;

/**
 *
 * @author Teun
 */
@ServerEndpoint(value = "/serverwsendpoint", encoders = TweetEncoder.class, decoders = TweetDecoder.class)
public class ApiEndpoint {

    public static final Set<Session> CONNECTEDCLIENTS = Collections.synchronizedSet(new HashSet());

    public ApiEndpoint() {
    }

    @OnOpen
    public void onOpen(Session session) {
        CONNECTEDCLIENTS.add(session);
        System.out.println("Connected Clients: " + CONNECTEDCLIENTS.size());
    }

    @OnClose
    public void onClose(Session session) {
        CONNECTEDCLIENTS.remove(session);
    }

    @OnMessage
    public void onMessage(TweetDTO tweet, Session session) {
        for (Session s : CONNECTEDCLIENTS) {
            try {
                s.getBasicRemote().sendObject(tweet);
            } catch (EncodeException | IOException ex) {
                Logger.getLogger(ApiEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
