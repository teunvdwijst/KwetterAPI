package ws;

import com.owlike.genson.Genson;
import dto.hateoas.TweetDTO;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Teun
 */
class TweetDecoder implements Decoder.Text<TweetDTO> {

    private final Genson genson = new Genson();

    @Override
    public TweetDTO decode(String string) throws DecodeException {
        return genson.deserialize(string, TweetDTO.class);
    }

    @Override
    public boolean willDecode(String string) {
        return true;
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
}
