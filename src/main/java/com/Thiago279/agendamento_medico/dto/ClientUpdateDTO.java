package com.Thiago279.agendamento_medico.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record ClientUpdateDTO(
        @Schema(description = "Novo número de telefone do cliente (opcional)")
        String email,
        @Schema(description = "Novo endereço de email do cliente (opcional)")
        String phoneNumber) {
}
