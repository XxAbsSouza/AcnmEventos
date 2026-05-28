package br.org.acnm.aplication.dto.users;

import br.org.acnm.domain.entity.AppUser;
import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
    UUID id,
    String username,
    String email,
    LocalDateTime createdAt
) {
    public UserResponseDTO(AppUser user) {
        this(
            user.id,
            user.username,
            user.email,
            user.createdAt
        );
    }
}
