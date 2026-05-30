package br.org.acnm.aplication.dto.event;

import br.org.acnm.domain.entity.event.Donation;
import br.org.acnm.domain.enums.DonationType;

import java.util.UUID;

public record DonationResponseDTO(
    Integer id,
    UUID clientId,
    DonationType type, 
    Integer amount,
    String productDescription
) {
    public DonationResponseDTO(Donation donation) {
        this(
            donation.id,
            donation.client != null ? donation.client.id : null,
            donation.type, 
            donation.amount,
            donation.productDescription
        );
    }
}
