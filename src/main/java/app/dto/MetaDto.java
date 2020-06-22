package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MetaDto implements Serializable {
    @JsonProperty(value = "dpi")
    private Short dpi;
}
