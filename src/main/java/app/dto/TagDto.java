package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TagDto implements Serializable {
    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "tagname")
    private String tagname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }
}
