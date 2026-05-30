package br.org.acnm.aplication.dto.products;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
    @NotBlank(message = "O nome da categoria é obrigatório")
    String name,

    Integer parentId
) {}