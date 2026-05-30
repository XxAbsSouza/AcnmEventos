package br.org.acnm.aplication.dto.products;

import br.org.acnm.domain.entity.product.Category;

public record CategoryResponseDTO(
    Integer id,
    String name,
    String path
) {
    public CategoryResponseDTO(Category category) {
        this(
            category.id,
            category.name,
            category.path
        );
    }
}