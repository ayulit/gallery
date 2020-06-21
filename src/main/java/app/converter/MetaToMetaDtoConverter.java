package app.converter;

import app.dto.MetaDto;
import app.entity.Meta;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MetaToMetaDtoConverter implements Converter<Meta, MetaDto> {
    @Override
    public MetaDto convert(Meta meta) {
        MetaDto metaDto = new MetaDto();
        metaDto.setDpi(meta.getDpi());

        return metaDto;
    }
}
