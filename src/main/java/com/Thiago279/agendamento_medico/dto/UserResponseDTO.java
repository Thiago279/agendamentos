package com.Thiago279.agendamento_medico.dto;

import com.Thiago279.agendamento_medico.entity.User;

public record UserResponseDTO(
        Long id,
        String username,
        String role
) {
    public UserResponseDTO(User user) {
        this(user.getId(), user.getUsername(), user.getRole());
    }
}
