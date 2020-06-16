package app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GroupDto extends BaseDto {
    @JsonProperty(value = "group_name")
    private String groupName;

    @JsonProperty(value = "parent")
    private Long parentId;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
