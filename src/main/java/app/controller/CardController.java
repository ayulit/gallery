package app.controller;

import app.dto.CardDto;
import app.service.CardService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<CardDto> getAll() {
        return cardService.getAll();
    }

    @GetMapping("/{id}")
    public CardDto getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping
    public CardDto createCard(@RequestBody CardDto cardDto) {
        return cardService.createCard(cardDto);
    }

    @PutMapping
    public CardDto updateCard(@RequestBody CardDto cardDto) {
        return cardService.updateCard(cardDto);
    }

    @DeleteMapping
    public void deleteCard(@PathParam("id") Long id) {
        cardService.deleteCard(id);
    }

    @PostMapping("/image")
    public String handleFile(@RequestParam("file") MultipartFile file) throws IOException {
        return IOUtils.toString(file.getBytes(), StandardCharsets.UTF_8.name());
    }

    @GetMapping("/search")
    public List<CardDto> searchCards(@RequestParam("query") String searchQuery) {
        return cardService.searchCards(searchQuery);
    }
}
