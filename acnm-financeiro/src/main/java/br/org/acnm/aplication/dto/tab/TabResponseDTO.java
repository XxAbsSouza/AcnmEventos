package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.entity.tab.Card;
import br.org.acnm.domain.entity.tab.Tab;
import br.org.acnm.domain.enums.SyncStatus;
import br.org.acnm.domain.enums.TabStatus; 
import java.time.LocalDateTime;
import java.util.UUID;

public record TabResponseDTO(
    UUID id,
    Card card,
    Integer tabNumber,
    TabStatus status,
    UUID personId,
    SyncStatus syncStatus,
    LocalDateTime deviceCreatedAt,
    LocalDateTime serverCreatedAt
) {
    public TabResponseDTO(Tab tab) {
        this(
            tab.id,
            tab.card,
            tab.tabNumber,
            tab.status,
            tab.person != null ? tab.person.id : null,
            tab.syncStatus,
            tab.deviceCreatedAt,
            tab.serverCreatedAt
        );
    }
}