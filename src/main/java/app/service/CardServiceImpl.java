package app.service;

import app.dto.CardDto;
import app.dto.MetaDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Override
    public List<CardDto> getAll() {
//        List<Card> cards = cardRepository.findAll();
//        return cards.stream().map(card -> conversionService.convert(card, CardDto.class)).collect(Collectors.toList());
        return Collections.singletonList(getCardById(1L));
    }

    @Override
    public CardDto getCardById(Long id) {
        CardDto cardDto = new CardDto();
        MetaDto metaDto = new MetaDto();

        metaDto.setDpi((short) 300);

        cardDto.setId(1L);
        cardDto.setTitle("Cool cats");
        cardDto.setThumbnail("cats.jpeg");
        cardDto.setDate(LocalDateTime.now());
        cardDto.setGroupId(2L);
        cardDto.setDescription("Just cats");
        cardDto.setMeta(metaDto);
        cardDto.setTags(Arrays.asList("cat", "cool"));
        cardDto.setLink("http://blablabla");

        return cardDto;
    }

    @Override
    public CardDto createCard(CardDto cardDto) {
        return cardDto;
    }

    @Override
    public CardDto updateCard(CardDto cardDto) {
        return cardDto;
    }

    @Override
    public void deleteCard(Long id) {

    }
}
