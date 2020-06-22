package app.controller;

import app.dto.TagDto;
import app.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TagController {
    private final TagService tagService;

    @GetMapping
    public List<TagDto> getAll() {
        return tagService.getAll();
    }

    @GetMapping("/{name}")
    public TagDto getTagByName(@PathVariable String name) {
        return tagService.getTagByName(name);
    }

    @PostMapping
    public TagDto createTag(@RequestBody TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

    @PutMapping
    public TagDto updateTag(@RequestBody TagDto tagDto) {
        return tagService.updateTag(tagDto);
    }

    @DeleteMapping
    public void deleteTagByName(@PathParam("name") String name) {
        tagService.deleteTagByName(name);
    }
}
