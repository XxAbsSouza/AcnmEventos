package br.org.acnm.aplication.dto.users;

import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

public record ClientRequestDTO(
    @NotBlank(message = "O nome é obrigatório")
    String firstName,
    
    @NotBlank(message = "O sobrenome é obrigatório")
    String lastName,

    String phone,
    
    UUID appUserId 
) {}