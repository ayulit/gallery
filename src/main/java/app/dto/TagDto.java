package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TagDto extends BaseDto {
    @JsonProperty(value = "tag_name")
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
