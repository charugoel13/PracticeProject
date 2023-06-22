package pojo;

import java.util.HashMap;
import java.util.Map;

public class Rain {
    double h ;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
