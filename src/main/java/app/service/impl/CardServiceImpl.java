package app.service.impl;

import app.dto.CardDto;
import app.entity.Card;
import app.entity.Meta;
import app.entity.Tag;
import app.exception.CardException;
import app.repository.CardRepository;
import app.repository.TagRepository;
import app.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final TagRepository tagRepository;
    private final ConversionService conversionService;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, TagRepository tagRepository, ConversionService conversionService) {
        this.cardRepository = cardRepository;
        this.tagRepository = tagRepository;
        this.conversionService = conversionService;
    }

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

        Card card = new Card();
        card.setTitle(cardDto.getTitle());
        card.setDate(cardDto.getDate());
        card.setGroupId(cardDto.getGroupId());
        card.setDescription(cardDto.getDescription());
        card.setMeta(conversionService.convert(cardDto.getMeta(), Meta.class));

        Set<String> tagNames = cardDto.getTags();
        Set<Tag> tags = tagRepository.getTagsByNames(tagNames);

        card.setTags(tags);
        card.setLink(cardDto.getLink());

        return conversionService.convert(cardRepository.save(card), CardDto.class);
    }

    @Override
    public CardDto updateCard(CardDto cardDto) {
        Card card = cardRepository.findById(cardDto.getId()).orElseThrow(() -> new CardException("Card not found."));

        card.setTitle(cardDto.getTitle());
        card.setDate(cardDto.getDate());
        card.setGroupId(cardDto.getGroupId());
        card.setDescription(cardDto.getDescription());
        card.setMeta(conversionService.convert(cardDto.getMeta(), Meta.class));

        Set<String> tagNames = cardDto.getTags();
        Set<Tag> tags = tagRepository.getTagsByNames(tagNames);

        card.setTags(tags);
        card.setLink(cardDto.getLink());

        return conversionService.convert(cardRepository.save(card), CardDto.class);
    }

    @Override
    public void deleteCard(Long id) {

    }
}
