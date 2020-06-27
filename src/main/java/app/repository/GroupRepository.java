package app.repository;

import app.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("select distinct category from Group category left join fetch category.cards card left join fetch card.tags tag where tag.tagName like %:tagName%")
    List<Group> searchGroupsByTagName(String tagName);
}
