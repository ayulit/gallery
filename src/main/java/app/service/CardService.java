package app.service;

import app.dto.CardDto;

import java.util.List;

public interface CardService {
    List<CardDto> getAll();
    CardDto getCardById(Long id);
    CardDto createCard(CardDto cardDto);
    CardDto updateCard(CardDto cardDto);
    void deleteCard(Long id);

    List<CardDto> searchCards(String searchQuery);
}
