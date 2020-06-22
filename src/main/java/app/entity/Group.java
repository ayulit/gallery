package app.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Group extends EntityBase {
    @Column(name = "group_name", nullable = false)
    private String groupName;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Card> cards;
}
