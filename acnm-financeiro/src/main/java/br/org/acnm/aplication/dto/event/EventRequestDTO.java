package br.org.acnm.aplication.dto.event;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record EventRequestDTO(
    @NotBlank(message = "O título do evento é obrigatório")
    String title,

    @NotNull(message = "A data de início é obrigatória")
    @FutureOrPresent(message = "A data de início não pode ser no passado")
    LocalDateTime startTime,

    @NotNull(message = "A data de término é obrigatória")
    LocalDateTime endTime
) {}
