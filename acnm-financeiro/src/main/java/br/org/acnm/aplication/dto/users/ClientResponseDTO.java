package br.org.acnm.aplication.dto.users;

import br.org.acnm.domain.entity.Client;
import java.util.UUID;

public record ClientResponseDTO(
    UUID id,
    String firstName,
    String lastName,
    String phone,
    UUID appUserId 
) {
    public ClientResponseDTO(Client client) {
        this(
            client.id,
            client.firstName,
            client.lastName,
            client.phone,
            client.appUser != null ? client.appUser.id : null 
        );
    }
}
