package br.org.acnm.aplication.dto.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record EventProductRequestDTO(
    @NotNull(message = "O ID do produto global é obrigatório")
    Integer globalProductId,

    @NotNull(message = "O preço unitário é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    Integer unitPrice 
) {}