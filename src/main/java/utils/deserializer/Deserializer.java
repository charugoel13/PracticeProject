package utils.deserializer;

import org.apache.juneau.json.JsonParser;
import org.apache.juneau.parser.ParseException;

public class Deserializer {
    JsonParser jsonParser = JsonParser.DEFAULT;

    public <T> T getDeserializedObj(String json, Class<T> type) throws ParseException {
        return jsonParser.parse(json, type);
    }
}
