package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class CardDto extends BaseDto {
    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "thumbnail")
    private String thumbnail;

    @JsonProperty(value = "date")
    private LocalDateTime date;

    @JsonProperty(value = "group")
    private Long groupId;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "meta")
    private MetaDto meta;

    @JsonProperty(value = "tags")
    private Set<String> tags;

    @JsonProperty(value = "link")
    private String link;
}
