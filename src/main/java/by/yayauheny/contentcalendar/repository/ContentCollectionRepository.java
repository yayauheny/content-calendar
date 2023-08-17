package by.yayauheny.contentcalendar.repository;


import by.yayauheny.contentcalendar.model.Content;
import by.yayauheny.contentcalendar.model.Status;
import by.yayauheny.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public boolean deleteById(Integer id) {
        return contentList.removeIf(c -> c.id().equals(id));
    }

    public void save(Content content) {
        contentList.add(content);
    }

    @PostConstruct
    public void init() {
        Content content = new Content(
                1,
                "First article",
                "Created by yayauheny",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                null
        );

        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().anyMatch(c -> c.id().equals(id));
    }

    public void update(Integer id, Content content) {
        Optional<Content> oldContent = contentList.stream()
                .filter(c -> c.id().equals(id))
                .findFirst();
        oldContent.ifPresent(old -> {
            int indexOfOldContent = contentList.indexOf(old);
            contentList.set(indexOfOldContent, content);
        });
    }
}
