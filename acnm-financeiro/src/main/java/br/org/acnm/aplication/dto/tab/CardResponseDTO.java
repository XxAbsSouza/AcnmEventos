package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.entity.Card;
import java.util.UUID;

public record CardResponseDTO(
    UUID id,
    Integer cardNumber,
    String accessToken,
    Boolean isActive
) {
    public CardResponseDTO(Card card) {
        this(
            card.id,
            card.cardNumber,
            card.accessToken,
            card.isActive
        );
    }
}