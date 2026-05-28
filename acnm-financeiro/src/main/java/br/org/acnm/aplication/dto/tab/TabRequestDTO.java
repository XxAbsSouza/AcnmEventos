package br.org.acnm.aplication.dto.tab;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

public record TabRequestDTO(
    @NotNull(message = "O ID da comanda gerado pelo dispositivo é obrigatório")
    UUID id, 

    UUID clientId, 

    UUID card,

    @NotNull(message = "O número da comanda/ficha é obrigatório")
    Integer tabNumber,

    @NotNull(message = "O horário de criação no dispositivo é obrigatório")
    LocalDateTime deviceCreatedAt
) {}