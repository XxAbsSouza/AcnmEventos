package br.org.acnm.aplication.dto.products;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record GlobalProductRequestDTO(
    @NotBlank(message = "O nome do produto é obrigatório")
    String name,

    @NotNull(message = "A categoria é obrigatória")
    Integer categoryId
) {}