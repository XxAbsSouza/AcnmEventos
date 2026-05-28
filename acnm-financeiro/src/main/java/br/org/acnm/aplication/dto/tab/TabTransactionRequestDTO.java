package br.org.acnm.aplication.dto.tab;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public record TabTransactionRequestDTO(
    @NotNull(message = "O ID da transação gerado pelo dispositivo é obrigatório")
    UUID id, 

    @NotNull(message = "O ID do produto do evento é obrigatório")
    UUID eventProductId,

    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 1, message = "A quantidade mínima é 1")
    Integer quantity,

    @NotNull(message = "A ação é obrigatória")
    String action,

    String notes,

    @NotNull(message = "O horário em que o pedido foi feito no dispositivo é obrigatório")
    LocalDateTime deviceCreatedAt 
) {}