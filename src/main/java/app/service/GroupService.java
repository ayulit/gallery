package app.service;

import app.dto.GroupDto;

import java.util.List;

public interface GroupService {
    List<GroupDto> getAll();
    GroupDto getGroupById(Long id);
    GroupDto createGroup(GroupDto groupDto);
    GroupDto updateGroup(GroupDto groupDto);
    void deleteGroup(Long id);

    List<GroupDto> getGroupsByTagName(String tagName);
}
