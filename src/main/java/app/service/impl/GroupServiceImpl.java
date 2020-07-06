package app.service.impl;

import app.converter.CustomConversionService;
import app.dto.GroupDto;
import app.entity.Group;
import app.exception.PersonException;
import app.repository.GroupRepository;
import app.service.GroupService;
import app.util.SpecificationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final CustomConversionService conversionService;

    @Override
    public List<GroupDto> getAll() {
        List<Group> groups = groupRepository.findAll();
        return conversionService.convert(groups, GroupDto.class);
    }

    @Override
    public GroupDto getGroupById(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new PersonException("Group not found."));
        return conversionService.convert(group, GroupDto.class);
    }

    @Override
    public GroupDto createGroup(GroupDto groupDto) {
        Group group = conversionService.convert(groupDto, Group.class);
        return conversionService.convert(groupRepository.save(group), GroupDto.class);
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        Group group = groupRepository.findById(groupDto.getId()).orElseThrow(() -> new PersonException("Group not found."));
        group.setGroupName(groupDto.getGroupName());

        return conversionService.convert(groupRepository.save(group), GroupDto.class);
    }

    @Override
    public void deleteGroup(Long id) {

    }

    @Override
    public List<GroupDto> getGroupsByTagName(String tagName) {
        return conversionService.convert(groupRepository.findAll(SpecificationUtil.groupsByTagName(tagName)), GroupDto.class);
    }
}
