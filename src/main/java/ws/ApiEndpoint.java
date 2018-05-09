package ws;

import com.owlike.genson.Genson;
import dto.hateoas.TweetDTO;
import java.io.IOException;
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
@Singleton
@ServerEndpoint("/serverwsendpoint")
public class ApiEndpoint {

    private final Set<Session> connectedClients = new HashSet();
    private final Genson genson = new Genson();

    public ApiEndpoint() {
    }

    @OnOpen
    public void OnOpen(Session session) {
        connectedClients.add(session);
        System.out.println("Connected Clients: " + connectedClients.size());
        /*try {
            Account a = new Account("user", "pass");
            a.setUsername("user");
            TweetDTO temp = new TweetDTO(1L, "test", "09/05/2018", a, new ArrayList<>());
            Genson genson = new Genson();
            String json = genson.serialize(temp);
            session.getBasicRemote().sendText(json);
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
    }

    public void newTweet(TweetDTO tweet) {
        for (Session s : connectedClients) {
            try {
                System.out.println("Sending");
                s.getBasicRemote().sendText(genson.serialize(tweet));
            } catch (IOException ex) {
                Logger.getLogger(ApiEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
    }
}
