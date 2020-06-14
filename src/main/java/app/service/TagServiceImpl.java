package app.service;

import app.dto.TagDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Override
    public List<TagDto> getAll() {
        return Collections.singletonList(getTagByName("cat"));
    }

    @Override
    public TagDto getTagByName(String name) {

        TagDto tagDto = new TagDto();
        tagDto.setId(1L);
        tagDto.setTagname("cat");

        return tagDto;
    }

    @Override
    public TagDto createTag(TagDto tagDto) {
        return tagDto;
    }

    @Override
    public TagDto updateTag(TagDto tagDto) {
        return tagDto;
    }

    @Override
    public void deleteTagByName(String name) {

    }
}
