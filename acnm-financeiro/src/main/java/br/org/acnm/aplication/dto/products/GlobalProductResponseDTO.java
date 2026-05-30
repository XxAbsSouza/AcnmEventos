package br.org.acnm.aplication.dto.products;

import br.org.acnm.domain.entity.product.GlobalProduct;

public record GlobalProductResponseDTO(
    Integer id,
    String name,
    Integer categoryId,
    String categoryName 
) {
    public GlobalProductResponseDTO(GlobalProduct product) {
        this(
            product.id,
            product.name,
            product.category != null ? product.category.id : null,
            product.category != null ? product.category.name : null
        );
    }
}
