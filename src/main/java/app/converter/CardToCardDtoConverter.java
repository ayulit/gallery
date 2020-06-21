package app.converter;

import app.dto.CardDto;
import app.dto.MetaDto;
import app.entity.Card;
import app.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CardToCardDtoConverter implements Converter<Card, CardDto> {

    private final ConversionService conversionService;

    @Autowired
    public CardToCardDtoConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public CardDto convert(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        cardDto.setTitle(card.getTitle());
        cardDto.setDate(card.getDate());
        cardDto.setGroupId(card.getGroupId());
        cardDto.setDescription(card.getDescription());
        cardDto.setMeta(conversionService.convert(card.getMeta(), MetaDto.class));

        Set<Tag> tags = card.getTags();
        Set<String> tagNames =  tags.stream().map(Tag::getTagName).collect(Collectors.toSet());
        cardDto.setTags(tagNames);

        cardDto.setLink(card.getLink());

        return cardDto;
    }
}
