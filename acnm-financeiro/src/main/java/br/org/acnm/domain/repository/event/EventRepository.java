package br.org.acnm.domain.repository.event;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.List;

import br.org.acnm.domain.entity.event.Event;

@ApplicationScoped
public class EventRepository implements PanacheRepositoryBase<Event, Integer> {

    public List<Event> findUpcomingOrActiveEvents() {
        return find("endTime >= ?1 ORDER BY startTime ASC", LocalDateTime.now()).list();
    }
}