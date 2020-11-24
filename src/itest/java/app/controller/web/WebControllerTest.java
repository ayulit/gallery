package app.controller.web;


import app.dto.CardDto;
import app.dto.GroupDto;
import app.dto.MetaDto;
import app.repository.TagRepository;
import app.service.CardService;
import app.service.GroupService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WebController.class)
class WebControllerTest {

    @MockBean
    private TagRepository tagRepository;

    @MockBean
    private GroupService groupService;

    @MockBean
    private CardService cardService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAll() throws Exception {

        List<GroupDto> groups = new ArrayList<>();
        GroupDto groupDto = new GroupDto();
        groupDto.setId(1L);
        groupDto.setGroupName(("X-files"));
        groups.add(groupDto);

        List<CardDto> cards = new ArrayList<>();
        CardDto cardDto = new CardDto();
        cardDto.setTitle("Roswell UFO incident");
        cardDto.setDate(LocalDateTime.now());
        cardDto.setGroupId(1L);
        cardDto.setDescription("UFO crash at a ranch near Roswell, New Mexico");

        MetaDto metaDto = new MetaDto();
        metaDto.setDpi((short) 300);

        cardDto.setMeta(metaDto);
        cards.add(cardDto);

        given(groupService.getAll()).willReturn(groups);
        given(cardService.getAll()).willReturn(cards);

        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("UFO")));
    }



}
