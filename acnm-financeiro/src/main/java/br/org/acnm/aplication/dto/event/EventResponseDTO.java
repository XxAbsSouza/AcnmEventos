package br.org.acnm.aplication.dto.event;
import java.time.LocalDateTime;

import br.org.acnm.domain.entity.event.Event;

public record EventResponseDTO(
    Integer id,
    String title,
    LocalDateTime startTime,
    LocalDateTime endTime
) {
    public EventResponseDTO(Event event) {
        this(event.id, event.title, event.startTime, event.endTime);
    }
}