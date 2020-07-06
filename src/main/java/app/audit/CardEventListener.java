package app.audit;

import app.entity.Card;
import app.entity.CardAudit;
import app.repository.CardAuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CardEventListener {

    private final CardAuditRepository cardAuditRepository;

    @EventListener(CardEvent.class)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateCardEvent(CardEvent cardEvent) {

        CardAudit cardAudit = new CardAudit();

        Card card = cardEvent.getCard();
        cardAudit.setCard(card);
        cardAudit.setOperation(cardEvent.getOperation());
        cardAudit.setVersion(card.getVersion());

        cardAuditRepository.save(cardAudit);
    }
}
