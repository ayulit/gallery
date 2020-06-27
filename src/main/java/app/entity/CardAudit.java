package app.entity;

import app.enums.Operation;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "card_audit")
public class CardAudit extends EntityBase {

    @CreationTimestamp
    @Column(name = "updated")
    private LocalDateTime operationDate;

    @ManyToOne
    private Card card;

    @Enumerated(EnumType.STRING)
    private Operation operation;

    @Column(name = "version")
    private Long version;
}
