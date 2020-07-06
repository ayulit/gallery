package app.audit;

import app.entity.Card;
import app.enums.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

@Component
public class CardAuditListener {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostUpdate
    public void afterUpdate(Card card) {
        sendEvent(CardEvent.builder().card(card).operation(Operation.UPDATE).build());
    }

    @PostPersist
    public void afterPersist(Card card) {
        sendEvent(CardEvent.builder().card(card).operation(Operation.INSERT).build());
    }

    @PostRemove
    public void afterRemove(Card card) {
        sendEvent(CardEvent.builder().card(card).operation(Operation.DELETE).build());
    }

    private void sendEvent(CardEvent cardEvent) {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
                @Override
                public void afterCommit() {
                    eventPublisher.publishEvent(cardEvent);
                }
            });
        } else {
            eventPublisher.publishEvent(cardEvent);
        }
    }
}
