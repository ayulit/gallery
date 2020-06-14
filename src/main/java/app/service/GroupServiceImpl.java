package app.service;

import app.dto.GroupDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Override
    public List<GroupDto> getAll() {
        return Collections.singletonList(getGroupById(2L));
    }

    @Override
    public GroupDto getGroupById(Long id) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(2L);
        groupDto.setGroupname("Cats");
        groupDto.setParentId(1L);
        return groupDto;
    }

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        return groupDto;
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        return groupDto;
    }

    @Override
    public void deleteGroup(Long id) {

    }
}
