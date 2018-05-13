package ws;

import com.owlike.genson.Genson;
import dto.hateoas.TweetDTO;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Teun
 */
class TweetEncoder implements Encoder.Text<TweetDTO> {

    private final Genson genson = new Genson();

    @Override
    public String encode(TweetDTO t) throws EncodeException {
        return genson.serialize(t);
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
}
