package br.org.acnm.domain.repository.event;

import br.org.acnm.domain.entity.event.Donation;
import br.org.acnm.domain.enums.DonationType;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class DonationRepository implements PanacheRepositoryBase<Donation, Integer> {

    public List<Donation> findByEventId(Integer eventId) {
        return find("""
                SELECT d
                FROM Donation d
                LEFT JOIN FETCH d.client
                WHERE d.event.id = ?1
                ORDER BY d.serverCreatedAt DESC
                """, eventId)
                .list();
    }

    public List<Donation> findByEventIdAndType(Integer eventId, DonationType type) {
        return find("""
                SELECT d
                FROM Donation d
                LEFT JOIN FETCH d.client
                WHERE d.event.id = ?1
                AND d.type = ?2
                ORDER BY d.serverCreatedAt DESC
                """, eventId, type)
                .list();
    }

    public List<Donation> findByClientId(UUID clientId) {
        return find("SELECT d FROM Donation d JOIN FETCH d.event WHERE d.client.id = ?1 ORDER BY d.serverCreatedAt DESC", clientId).list();
    }
}