package app.converter;

import app.dto.GroupDto;
import app.entity.Group;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GroupToGroupDtoConverter implements Converter<Group, GroupDto> {
    @Override
    public GroupDto convert(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setGroupName(group.getGroupName());

        return groupDto;
    }
}
