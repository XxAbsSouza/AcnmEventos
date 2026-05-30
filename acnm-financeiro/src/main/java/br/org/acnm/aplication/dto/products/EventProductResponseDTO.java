package br.org.acnm.aplication.dto.products;
import br.org.acnm.domain.entity.product.EventProduct;

public record EventProductResponseDTO(
    Integer id,
    Integer globalProductId,
    Integer unitPrice,
    Boolean isActive
) {
    public EventProductResponseDTO(EventProduct eventProduct) {
        this(
            eventProduct.id, 
            eventProduct.globalProduct.id, 
            eventProduct.unitPrice, 
            eventProduct.isActive
        );
    }
}
