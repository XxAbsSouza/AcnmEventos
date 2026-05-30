package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.entity.tab.Card;


public record CardResponseDTO(
    Long id,
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