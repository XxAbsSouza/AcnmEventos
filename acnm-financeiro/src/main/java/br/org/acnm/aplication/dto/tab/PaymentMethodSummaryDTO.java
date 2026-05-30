package br.org.acnm.aplication.dto.tab;

import br.org.acnm.domain.enums.PaymentMethod;

public record PaymentMethodSummaryDTO(
    PaymentMethod method, 
    Long total 
) {}