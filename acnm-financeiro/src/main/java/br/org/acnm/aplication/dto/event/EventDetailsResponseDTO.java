package br.org.acnm.aplication.dto.event;

import java.util.List;
import java.util.UUID;

import br.org.acnm.aplication.dto.products.EventProductResponseDTO;

public record EventDetailsResponseDTO(
    UUID id,
    String title,
    List<EventProductResponseDTO> menu,
    List<EventTeamResponseDTO> team
) {}