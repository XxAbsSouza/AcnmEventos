package br.org.acnm.aplication.dto.tab;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CardRequestDTO(
    @NotNull(message = "O número do cartão é obrigatório")
    @Positive(message = "O número do cartão deve ser positivo")
    Integer cardNumber
) {}