package app.audit;

import app.entity.Card;
import app.enums.Operation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardEvent {
    private Card card;
    private Operation operation;
}
