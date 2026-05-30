package br.org.acnm.domain.repository.tab;

import br.org.acnm.domain.entity.tab.TabTransaction;
import br.org.acnm.domain.enums.TabAction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class TabTransactionRepository implements PanacheRepositoryBase<TabTransaction, UUID> {

    public List<TabTransaction> findPendingReviewByEvent(Integer eventId) {
        return find("""
                SELECT tx FROM TabTransaction tx 
                WHERE tx.tab.event.id = ?1 
                AND tx.needsReview = true
                """, eventId).list();
    }
    public List<TabTransaction> findLedgerByTabId(UUID tabId) {

        return find("""
                SELECT tx
                FROM TabTransaction tx
                JOIN FETCH tx.eventProduct ep
                JOIN FETCH ep.globalProduct gp
                WHERE tx.tab.id = ?1
                ORDER BY tx.deviceCreatedAt ASC
                """, tabId)
                .list();
    }

    public Integer calculateNetConsumed(UUID tabId) {

    Long result = getEntityManager()
            .createQuery("""
                SELECT COALESCE(SUM(
                    CASE
                        WHEN tx.action = :add
                            THEN (tx.quantity * tx.unitPrice)

                        WHEN tx.action = :remove
                            THEN -(tx.quantity * tx.unitPrice)

                        ELSE 0
                    END
                ), 0)
                FROM TabTransaction tx
                WHERE tx.tab.id = :tabId
                """, Long.class)
            .setParameter("add", TabAction.ADD)
            .setParameter("remove", TabAction.REMOVE)
            .setParameter("tabId", tabId)
            .getSingleResult();

    return Math.toIntExact(result);
}
    
}