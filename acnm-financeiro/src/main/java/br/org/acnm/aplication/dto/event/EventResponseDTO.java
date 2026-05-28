package br.org.acnm.aplication.dto.event;
import br.org.acnm.domain.entity.Event;
import java.time.LocalDateTime;
import java.util.UUID;

public record EventResponseDTO(
    UUID id,
    String title,
    LocalDateTime startTime,
    LocalDateTime endTime
) {
    public EventResponseDTO(Event event) {
        this(event.id, event.title, event.startTime, event.endTime);
    }
}