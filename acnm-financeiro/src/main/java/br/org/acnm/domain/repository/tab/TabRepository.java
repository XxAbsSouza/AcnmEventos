package br.org.acnm.domain.repository.tab;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.org.acnm.domain.entity.tab.Tab;
import br.org.acnm.domain.enums.TabStatus;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TabRepository implements PanacheRepositoryBase<Tab, UUID> {

    public Optional<Tab> findByIdWithDetails(UUID id) {
        return find("""
                SELECT t FROM Tab t 
                LEFT JOIN FETCH t.client 
                LEFT JOIN FETCH t.card 
                WHERE t.id = ?1
                """, id).firstResultOptional();
    }

    public List<Tab> findOpenTabsByEvent(Integer eventId) {
        return find("event.id = ?1 AND status = ?2", eventId, TabStatus.OPEN).list();
    }

    public Optional<Tab> findActiveTabByCard(Long cardId, Integer eventId) {
        return find("""
            SELECT t FROM Tab t
            WHERE t.card.id = ?1
            AND t.event.id = ?2
            AND t.status = ?3
            """,
            cardId,
            eventId,
            TabStatus.OPEN
        ).firstResultOptional();
    }
}