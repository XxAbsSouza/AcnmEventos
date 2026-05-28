package br.org.acnm.aplication.dto.products;
import br.org.acnm.domain.entity.EventProduct;
import java.util.UUID;

public record EventProductResponseDTO(
    UUID id,
    UUID globalProductId,
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
