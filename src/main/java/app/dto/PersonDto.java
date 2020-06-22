package app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto extends BaseDto {
    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "user_name")
    private String userName;
}
