package app.service.impl;

import app.dto.GroupDto;
import app.entity.Group;
import app.exception.PersonException;
import app.repository.GroupRepository;
import app.service.GroupService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final ConversionService conversionService;

    public GroupServiceImpl(GroupRepository groupRepository, ConversionService conversionService) {
        this.groupRepository = groupRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<GroupDto> getAll() {
        List<Group> groups = groupRepository.findAll();
        return groups.stream().map(group -> conversionService.convert(group, GroupDto.class)).collect(Collectors.toList());
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
}
