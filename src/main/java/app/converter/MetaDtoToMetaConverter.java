package app.converter;

import app.dto.MetaDto;
import app.entity.Meta;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MetaDtoToMetaConverter implements Converter<MetaDto, Meta> {
    @Override
    public Meta convert(MetaDto metaDto) {
        Meta meta = new Meta();
        meta.setDpi(metaDto.getDpi());

        return meta;
    }
}
