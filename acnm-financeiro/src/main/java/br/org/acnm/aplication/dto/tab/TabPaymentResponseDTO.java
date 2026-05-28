package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.entity.TabPayment;
import br.org.acnm.domain.enums.PaymentMethod;
import java.time.LocalDateTime;
import java.util.UUID;

public record TabPaymentResponseDTO(
    UUID id,
    UUID tabId,
    UUID receivedByUserId,
    Integer amount,
    PaymentMethod paymentMethod,
    String syncStatus,
    LocalDateTime deviceCreatedAt,
    LocalDateTime serverCreatedAt
) {
    public TabPaymentResponseDTO(TabPayment payment) {
        this(
            payment.id,
            payment.tab != null ? payment.tab.id : null,
            payment.appUser != null ? payment.appUser.id : null,
            payment.amount,
            payment.paymentMethod,
            payment.syncStatus,
            payment.deviceCreatedAt,
            payment.serverCreatedAt
        );
    }
}