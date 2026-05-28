package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.entity.Card;
import br.org.acnm.domain.entity.Tab;
import br.org.acnm.domain.enums.TabStatus; 
import java.time.LocalDateTime;
import java.util.UUID;

public record TabResponseDTO(
    UUID id,
    Card card,
    Integer tabNumber,
    TabStatus status,
    UUID clientId,
    String syncStatus,
    LocalDateTime deviceCreatedAt,
    LocalDateTime serverCreatedAt
) {
    public TabResponseDTO(Tab tab) {
        this(
            tab.id,
            tab.card,
            tab.tabNumber,
            tab.status,
            tab.client != null ? tab.client.id : null,
            tab.syncStatus,
            tab.deviceCreatedAt,
            tab.serverCreatedAt
        );
    }
}