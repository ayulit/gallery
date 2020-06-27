package app.aspect;

import app.entity.Card;
import app.entity.CardAudit;
import app.repository.CardAuditRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Aspect
@Component
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CardAuditAspect {

    private final CardAuditRepository cardAuditRepository;
    private final EntityManager entityManager;

    @Transactional
    @AfterReturning(pointcut = "execution(* app.repository.CardRepository.save(..))", returning = "returnValue")
    public void auditCardUpdate(Object returnValue) {
        if (returnValue instanceof Card) {
            Card card = (Card) returnValue;

            // FIXME  fetching version from db
            entityManager.flush();
            entityManager.refresh(card);

            CardAudit cardAudit = new CardAudit();
            cardAudit.setCard(card);
            cardAudit.setOperation(card.getOperation());
            cardAudit.setVersion(card.getVersion());

            cardAuditRepository.save(cardAudit);
        }
   }
}
