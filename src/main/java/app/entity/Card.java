package app.entity;

import app.enums.Operation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"group", "tags"}, callSuper = true)
@Entity
@Table(name = "card")
public class Card extends EntityBase {
    @Column(name = "title")
    private String title;

    @Column(name = "added")
    private LocalDateTime addedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @ToString.Exclude
    private Group group;

    @Column(name = "description")
    private String description;

    @Embedded
    private Meta meta;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "card_tags",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @ToString.Exclude
    private Set<Tag> tags;

    @Column(name = "link")
    private String link;

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    /* AUDIT */

    @Version
    private Long version;

    @Transient
    private Operation operation;

    @PrePersist
    public void onPrePersist() {
        audit(Operation.INSERT);
    }

    @PreUpdate
    public void onPreUpdate() {
        audit(Operation.UPDATE);
    }

    @PreRemove
    public void onPreRemove() {
        audit(Operation.DELETE);
    }

    private void audit(Operation operation) {
        setOperation(operation);
    }

}
