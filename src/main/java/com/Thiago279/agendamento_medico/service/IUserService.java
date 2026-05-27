package com.Thiago279.agendamento_medico.service;

import com.Thiago279.agendamento_medico.dto.UserRequestDTO;
import com.Thiago279.agendamento_medico.dto.UserResponseDTO;
import java.util.List;

public interface IUserService {
    UserResponseDTO salvar(UserRequestDTO dto);
    List<UserResponseDTO> listarTodos();
}
