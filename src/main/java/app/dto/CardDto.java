package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Set;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MetaDto getMeta() {
        return meta;
    }

    public void setMeta(MetaDto meta) {
        this.meta = meta;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
