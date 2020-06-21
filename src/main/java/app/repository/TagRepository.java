package app.repository;

import app.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String name);
    Set<Tag> findByTagNameIn(Set<String> tagNames);
}
