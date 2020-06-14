package app.service;

import app.dto.TagDto;

import java.util.List;

public interface TagService {
    List<TagDto> getAll();
    TagDto getTagByName(String name);
    TagDto createTag(TagDto tagDto);
    TagDto updateTag(TagDto tagDto);
    void deleteTagByName(String name);
}
