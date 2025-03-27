package com.Thiago279.agendamento_medico.dto;

import java.time.LocalDateTime;

public record ScheduleRequestDTO(
        Long clientId,
        LocalDateTime startDate
) {

}
