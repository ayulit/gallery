package app.controller;

import app.dto.CardDto;
import app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public abstract class CardController {
    private final CardService cardService;

    public List<CardDto> getAll() {
        return cardService.getAll();
    }

    public CardDto getCardById(Long id) {
        return cardService.getCardById(id);
    }

    public CardDto createCard(CardDto cardDto) {
        return cardService.createCard(cardDto);
    }

    public CardDto updateCard(CardDto cardDto) {
        return cardService.updateCard(cardDto);
    }

    public void deleteCard(Long id) {
        cardService.deleteCard(id);
    }

    public String handleFile(MultipartFile file) throws IOException {
        return IOUtils.toString(file.getBytes(), StandardCharsets.UTF_8.name());
    }

    public List<CardDto> searchCards(String searchQuery) {
        return cardService.searchCards(searchQuery);
    }
}
