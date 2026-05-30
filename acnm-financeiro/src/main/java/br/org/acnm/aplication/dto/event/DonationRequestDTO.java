package br.org.acnm.aplication.dto.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record DonationRequestDTO(
    Integer clientId,

    @NotBlank(message = "O tipo de doação é obrigatório (ex: DINHEIRO, ALIMENTO)")
    String type,

    @PositiveOrZero(message = "O valor não pode ser negativo")
    Integer amount,

    String productDescription 
) {}
