package app.service.impl;

import app.converter.CustomConversionService;
import app.dto.CardDto;
import app.entity.Card;
import app.entity.Group;
import app.entity.Meta;
import app.entity.Tag;
import app.exception.CardException;
import app.repository.CardRepository;
import app.repository.TagRepository;
import app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.JoinType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final TagRepository tagRepository;
    private final CustomConversionService conversionService;

    @Override
    public List<CardDto> getAll() {
        List<Card> cards = cardRepository.findAll();
        return cards.stream().map(card -> conversionService.convert(card, CardDto.class)).collect(Collectors.toList());
    }

    @Override
    public CardDto getCardById(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new CardException("Card not found."));
        return conversionService.convert(card, CardDto.class);
    }

    @Override
    public CardDto createCard(CardDto cardDto) {
        Card card = conversionService.convert(cardDto, Card.class);
        return conversionService.convert(cardRepository.save(card), CardDto.class);
    }

    @Override
    public CardDto updateCard(CardDto cardDto) {
        Card card = cardRepository.findById(cardDto.getId()).orElseThrow(() -> new CardException("Card not found."));

        card.setTitle(cardDto.getTitle());
        card.setAddedDate(LocalDateTime.now());

        Group group = new Group();
        group.setId(cardDto.getGroupId());
        card.setGroup(group);

        card.setDescription(cardDto.getDescription());
        card.setMeta(conversionService.convert(cardDto.getMeta(), Meta.class));

        Set<String> tagNames = cardDto.getTags();
        Set<Tag> tags = tagRepository.findByTagNameIn(tagNames);

        card.setTags(tags);
        card.setLink(cardDto.getLink());

        return conversionService.convert(cardRepository.save(card), CardDto.class);
    }

    @Override
    public void deleteCard(Long id) {

    }

    @Override
    public List<CardDto> searchCards(String searchQuery) {

        String likeQ = "%" + searchQuery.trim() + "%";
        Specification<Card> cardSpecification = ((root, query, cb) -> {
            query.distinct(true);
            return cb.or(
                    cb.like(root.get("title"), likeQ),
                    cb.like(root.get("description"), likeQ),
                    cb.like(root.join("tags", JoinType.LEFT).get("tagName"), likeQ)
            );
        });

        List<Card> cards = cardRepository.findAll(cardSpecification);

        return conversionService.convert(cards, CardDto.class);
    }
}
