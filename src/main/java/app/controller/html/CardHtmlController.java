package app.controller.html;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import app.controller.CardController;
import app.dto.CardDto;
import app.dto.GroupDto;
import app.service.CardService;
import app.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/cards")
public class CardHtmlController extends CardController {

    private final GroupService groupService;

    public CardHtmlController(CardService cardService, GroupService groupService) {
        super(cardService);
        this.groupService = groupService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<CardDto> cards = getAll();

        Map<Long, String> groups = groupService.getAll()
                .stream()
                .collect(Collectors.toMap(GroupDto::getId, GroupDto::getGroupName));

        model.addAttribute("cards", cards);
        model.addAttribute("groups", groups);
        return "cards";
    }

}
