package app.converter;

import app.dto.GroupDto;
import app.entity.Group;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GroupDtoToGroupConverter implements Converter<GroupDto, Group> {
    @Override
    public Group convert(GroupDto groupDto) {
        Group group = new Group();
        group.setGroupName(group.getGroupName());

        return group;
    }
}
