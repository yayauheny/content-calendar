package by.yayauheny.contentcalendar.controller;

import by.yayauheny.contentcalendar.exception.ContentNotFoundException;
import by.yayauheny.contentcalendar.model.Content;
import by.yayauheny.contentcalendar.repository.ContentCollectionRepository;
import by.yayauheny.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Profile("prod")
@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(ContentNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void save(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ContentNotFoundException();
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable String status){
        return repository.findByStatus(status);
    }
}
