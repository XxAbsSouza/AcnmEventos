package br.org.acnm.aplication.dto.event;
import br.org.acnm.domain.enums.RoleType;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record EventTeamRequestDTO(
    @NotNull(message = "O ID do usuário é obrigatório")
    UUID userId,

    @NotNull(message = "O tipo de função (RoleType) é obrigatório")
    RoleType roleType
) {}
