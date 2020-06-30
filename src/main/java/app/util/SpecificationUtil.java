package app.util;

import app.entity.Card;
import app.entity.Group;
import app.entity.Tag;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class SpecificationUtil {
    public static Specification<Group> groupsByTagName(String tagName) {
        return (root, query, cb) -> {
            // FIXME org.hibernate.QueryException: query specified join fetching, but the owner of the fetched association was not present in the select list
//            root.fetch("cards");
            Join<Card, Group> cardJoin = root.join("cards", JoinType.LEFT);
            // FIXME
//            cardJoin.fetch("tags");
            Join<Tag, Card> tagJoin = cardJoin.join("tags", JoinType.LEFT);
            query.distinct(true);
            return cb.and(cb.like(tagJoin.get("tagName"), tagName));
        };
    }
}
