package br.org.acnm.aplication.dto.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.UUID;

public record EventProductRequestDTO(
    @NotNull(message = "O ID do produto global é obrigatório")
    UUID globalProductId,

    @NotNull(message = "O preço unitário é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    Integer unitPrice 
) {}