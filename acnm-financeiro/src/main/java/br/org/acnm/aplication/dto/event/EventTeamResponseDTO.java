package br.org.acnm.aplication.dto.event;

import br.org.acnm.domain.entity.EventTeam;
import br.org.acnm.domain.enums.RoleType;
import java.util.UUID;

public record EventTeamResponseDTO(
    UUID id,
    UUID userId,
    RoleType roleType
) {
    public EventTeamResponseDTO(EventTeam team) {
        this(
            team.id, 
            team.appUser.id, 
            team.roleType
        );
    }
}