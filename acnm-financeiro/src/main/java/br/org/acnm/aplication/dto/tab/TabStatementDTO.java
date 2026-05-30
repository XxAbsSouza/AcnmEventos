package br.org.acnm.aplication.dto.tab;

import java.util.List;

public record TabStatementDTO(
    List<TabTransactionResponseDTO> transactions,
    List<TabPaymentResponseDTO> payments,
    Integer totalConsumed,
    Integer totalPaid,
    Integer balance
) {}
