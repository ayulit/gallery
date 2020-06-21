package app.repository;

import app.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("SELECT t FROM Tag t WHERE t.tagName = ?1")
    Tag findByName(String name);

    Tag findByTagName(String name);

    @Query("SELECT t FROM Tag t WHERE t.tagName in ?1")
    Set<Tag> getTagsByNames(Set<String> tagNames);
}
