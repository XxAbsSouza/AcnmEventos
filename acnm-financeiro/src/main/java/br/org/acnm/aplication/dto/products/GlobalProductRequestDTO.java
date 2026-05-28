package br.org.acnm.aplication.dto.products;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record GlobalProductRequestDTO(
    @NotBlank(message = "O nome do produto é obrigatório")
    String name,

    @NotNull(message = "O preço é obrigatório")
    @Min(value = 0, message = "O preço não pode ser negativo")
    Integer price, 

    @NotNull(message = "A categoria é obrigatória")
    UUID categoryId
) {}