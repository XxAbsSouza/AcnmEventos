package br.org.acnm.domain.repository.event;

import br.org.acnm.domain.entity.event.EventTeam;
import br.org.acnm.domain.enums.RoleType;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ApplicationScoped
public class EventTeamRepository implements PanacheRepositoryBase<EventTeam, UUID> {

    public Optional<EventTeam> findByUserAndEvent(UUID userId, Integer eventId) {
        return find(
                "appUser.id = ?1 and event.id = ?2",
                userId,
                eventId
        ).firstResultOptional();
    }

    public Optional<RoleType> findRoleByUserAndEvent(UUID userId, Integer eventId) {

        return getEntityManager()
                .createQuery("""
                    SELECT et.roleType
                    FROM EventTeam et
                    WHERE et.appUser.id = :userId
                    AND et.event.id = :eventId
                """, RoleType.class)
                .setParameter("userId", userId)
                .setParameter("eventId", eventId)
                .getResultStream()
                .findFirst();
    }

    public List<EventTeam> findByEventId(Integer eventId) {
        return find("""
                SELECT et
                FROM EventTeam et
                JOIN FETCH et.appUser
                WHERE et.event.id = ?1
                """, eventId)
                .list();
    }

    public List<EventTeam> findByUserId(UUID userId) {
        return find("""
                SELECT et
                FROM EventTeam et
                JOIN FETCH et.event
                WHERE et.appUser.id = ?1
                """, userId)
                .list();
    }
}