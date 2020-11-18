package app.controller.api;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

import app.controller.CardController;
import app.dto.CardDto;
import app.service.CardService;
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

@RestController
@RequestMapping("/api/cards")
public class CardJsonController extends CardController {

    public CardJsonController(CardService cardService) {
        super(cardService);
    }

    @GetMapping
    @Override
    public List<CardDto> getAll() {
        return super.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public CardDto getCardById(@PathVariable Long id) {
        return super.getCardById(id);
    }

    @PostMapping
    @Override
    public CardDto createCard(@RequestBody CardDto cardDto) {
        return super.createCard(cardDto);
    }

    @PutMapping
    @Override
    public CardDto updateCard(@RequestBody CardDto cardDto) {
        return super.updateCard(cardDto);
    }

    @DeleteMapping
    @Override
    public void deleteCard(@PathParam("id") Long id) {
        super.deleteCard(id);
    }

    @PostMapping("/image")
    @Override
    public String handleFile(@RequestParam("file") MultipartFile file) throws IOException {
        return super.handleFile(file);
    }

    @GetMapping("/search")
    @Override
    public List<CardDto> searchCards(@RequestParam("query") String searchQuery) {
        return super.searchCards(searchQuery);
    }
}

