package utils.serializer;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.*;

public class Serializer {
    JsonSerializer jsonSerializer = JsonSerializer.DEFAULT_READABLE;

    public <T>String getJsonString(T obj) throws SerializeException {
        String jsonString = jsonSerializer.serialize(obj);
        return jsonString;
    }
}
