package br.org.acnm.aplication.dto.products;

import br.org.acnm.domain.entity.GlobalProduct;
import java.util.UUID;

public record GlobalProductResponseDTO(
    UUID id,
    String name,
    UUID categoryId,
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
