package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GroupDto extends BaseDto {
    @JsonProperty(value = "group_name")
    private String groupName;

    @JsonProperty(value = "parent")
    private Long parentId;
}
