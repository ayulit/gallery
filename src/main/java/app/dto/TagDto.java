package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TagDto extends BaseDto {
    @JsonProperty(value = "tag_name")
    private String tagName;
}
