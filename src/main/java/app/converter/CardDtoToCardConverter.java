package app.converter;

import app.dto.CardDto;
import app.entity.Card;
import app.entity.Group;
import app.entity.Meta;
import app.entity.Tag;
import app.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CardDtoToCardConverter implements Converter<CardDto, Card> {
    private final TagRepository tagRepository;
    private final ConversionService conversionService;

    @Autowired
    public CardDtoToCardConverter(TagRepository tagRepository, ConversionService conversionService) {
        this.tagRepository = tagRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Card convert(CardDto cardDto) {
        Card card = new Card();
        card.setTitle(cardDto.getTitle());
        card.setDate(cardDto.getDate());

        Group group = new Group();
        group.setId(cardDto.getGroupId());
        card.setGroup(group);

        card.setDescription(cardDto.getDescription());
        card.setMeta(conversionService.convert(cardDto.getMeta(), Meta.class));

        Set<String> tagNames = cardDto.getTags();
        Set<Tag> tags = tagRepository.findByTagNameIn(tagNames);
        card.setTags(tags);

        card.setLink(cardDto.getLink());

        return card;
    }
}
