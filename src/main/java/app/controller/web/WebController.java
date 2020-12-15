package app.controller.web;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import app.controller.CardController;
import app.dto.CardDto;
import app.dto.GroupDto;
import app.service.CardService;
import app.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor_ = {@Autowired })
public class WebController {

    private final CardService cardService;
    private final GroupService groupService;

    @GetMapping
    // модель приходит с UI
    public String getAll(Model model) {
        List<CardDto> cards = cardService.getAll();

        Map<Long, String> groups = groupService.getAll()
                .stream()
                .collect(Collectors.toMap(GroupDto::getId, GroupDto::getGroupName));

        // наполняем модель
        model.addAttribute("cards", cards);
        model.addAttribute("groups", groups);

        // возвращаем имя вьюхи
        return "index";
    }

}
