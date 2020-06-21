package app.converter;

import app.dto.TagDto;
import app.entity.Tag;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TagDtoToTagConverter implements Converter<TagDto, Tag> {
    @Override
    public Tag convert(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setTagName(tagDto.getTagName());

        return tag;
    }
}
