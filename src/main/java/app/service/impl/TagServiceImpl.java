package app.service.impl;

import app.dto.TagDto;
import app.entity.Tag;
import app.repository.TagRepository;
import app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ConversionService conversionService;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, ConversionService conversionService) {
        this.tagRepository = tagRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<TagDto> getAll() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream().map(tag -> conversionService.convert(tag, TagDto.class)).collect(Collectors.toList());
    }

    @Override
    public TagDto getTagByName(String name) {
        Tag tag = tagRepository.findByName(name);
        return conversionService.convert(tag, TagDto.class);

    }

    @Override
    public TagDto createTag(TagDto tagDto) {
        Tag tag = conversionService.convert(tagDto, Tag.class);
        return conversionService.convert(tagRepository.save(tag), TagDto.class);
    }

    @Override
    public TagDto updateTag(TagDto tagDto) {
        Tag tag = tagRepository.findByName(tagDto.getTagName());
        tag.setTagName(tagDto.getTagName());

        return conversionService.convert(tagRepository.save(tag), TagDto.class);
    }

    @Override
    public void deleteTagByName(String name) {

    }
}
