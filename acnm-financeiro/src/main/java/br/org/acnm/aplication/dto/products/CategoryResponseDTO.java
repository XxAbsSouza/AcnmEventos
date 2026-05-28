package br.org.acnm.aplication.dto.products;

import br.org.acnm.domain.entity.Category;
import java.util.UUID;

public record CategoryResponseDTO(
    UUID id,
    String name
) {
    public CategoryResponseDTO(Category category) {
        this(
            category.id,
            category.name
        );
    }
}