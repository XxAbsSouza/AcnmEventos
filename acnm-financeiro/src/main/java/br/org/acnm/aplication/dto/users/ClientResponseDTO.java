package br.org.acnm.aplication.dto.users;

import java.util.UUID;

import br.org.acnm.domain.entity.users.Person;

public record ClientResponseDTO(
    UUID id,
    String firstName,
    String lastName,
    String phone,
    UUID appUserId 
) {
    public ClientResponseDTO(Person client) {
        this(
            client.id,
            client.firstName,
            client.lastName,
            client.phone,
            client.appUser != null ? client.appUser.id : null 
        );
    }
}
