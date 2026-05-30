package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.entity.tab.Card;


public record CardPublicResponseDTO(
    Long id,
    Integer cardNumber,
    Boolean isActive
) {

    public CardPublicResponseDTO(Card card) {
        this(
            card.id,
            card.cardNumber,
            card.isActive
        );
    }
}