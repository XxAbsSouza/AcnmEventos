package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.UUID;

public record TabPaymentRequestDTO(
    @NotNull(message = "O ID do pagamento gerado pelo dispositivo é obrigatório")
    UUID id, 

    @NotNull(message = "O ID da comanda é obrigatório")
    UUID tabId,

    @NotNull(message = "O ID do usuário que recebeu o pagamento é obrigatório")
    UUID receivedByUserId,

    @NotNull(message = "O valor do pagamento é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    Integer amount,

    @NotNull(message = "O método de pagamento é obrigatório")
    PaymentMethod paymentMethod,

    @NotNull(message = "O horário do pagamento no dispositivo é obrigatório")
    LocalDateTime deviceCreatedAt
) {}