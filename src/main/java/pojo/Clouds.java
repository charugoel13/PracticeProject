package pojo;

import java.util.HashMap;
import java.util.Map;

public class Clouds {
    private int all;

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
