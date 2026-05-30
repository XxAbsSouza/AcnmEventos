package br.org.acnm.aplication.dto.event;

import java.util.List;

import br.org.acnm.aplication.dto.products.EventProductResponseDTO;

public record EventDetailsResponseDTO(
    Integer id,
    String title,
    List<EventProductResponseDTO> menu,
    List<EventTeamResponseDTO> team
) {}