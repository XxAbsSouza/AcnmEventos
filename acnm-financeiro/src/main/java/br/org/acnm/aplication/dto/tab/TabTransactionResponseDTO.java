package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.entity.tab.TabTransaction;
import br.org.acnm.domain.enums.SyncStatus;
import br.org.acnm.domain.enums.TabAction;
import java.util.UUID;
import java.time.LocalDateTime;

public record TabTransactionResponseDTO(
    UUID id,
    Integer eventProductId,
    Integer quantity,
    Integer unitPrice,
    TabAction action,
    String notes,
    Boolean needsReview, 
    SyncStatus syncStatus,
    LocalDateTime deviceCreatedAt,
    LocalDateTime serverCreatedAt
) {
    public TabTransactionResponseDTO(TabTransaction transaction) {
        this(
            transaction.id,
            transaction.eventProduct.id,
            transaction.quantity,
            transaction.unitPrice,
            transaction.action,
            transaction.notes,
            transaction.needsReview, 
            transaction.syncStatus,
            transaction.deviceCreatedAt,
            transaction.serverCreatedAt
        );
    }
}