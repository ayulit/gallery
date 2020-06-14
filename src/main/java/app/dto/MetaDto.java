package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MetaDto implements Serializable {
    @JsonProperty(value = "dpi")
    private Short dpi;

    public Short getDpi() {
        return dpi;
    }

    public void setDpi(Short dpi) {
        this.dpi = dpi;
    }
}
