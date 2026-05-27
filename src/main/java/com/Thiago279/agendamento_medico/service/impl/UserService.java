package com.Thiago279.agendamento_medico.service.impl;

import com.Thiago279.agendamento_medico.dto.UserRequestDTO;
import com.Thiago279.agendamento_medico.dto.UserResponseDTO;
import com.Thiago279.agendamento_medico.entity.User;
import com.Thiago279.agendamento_medico.repository.UserRepository;
import com.Thiago279.agendamento_medico.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserResponseDTO salvar(UserRequestDTO dto) {
        if (userRepository.findByUsername(dto.username()).isPresent()) {
            throw new RuntimeException("Este nome de usuário já está cadastrado.");
        }

        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(dto.password()); // Texto puro provisório

        // Mantendo a flexibilidade da role opcional
        if (dto.role() == null || dto.role().isBlank()) {
            user.setRole("USER");
        } else {
            user.setRole(dto.role());
        }

        User userSalvo = userRepository.save(user);
        return new UserResponseDTO(userSalvo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDTO> listarTodos() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDTO::new)
                .toList();
    }
}
