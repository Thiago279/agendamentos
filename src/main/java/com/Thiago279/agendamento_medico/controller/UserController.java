package com.Thiago279.agendamento_medico.controller;

import com.Thiago279.agendamento_medico.dto.UserRequestDTO;
import com.Thiago279.agendamento_medico.dto.UserResponseDTO;
import com.Thiago279.agendamento_medico.service.impl.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController( UserService service ){
        this.userService = service;
    }
    @Operation(summary = "Registra usuario (nome, senha , role)", method = "POST")

    @PostMapping
    public ResponseEntity<UserResponseDTO> cadastrar(@RequestBody @Valid UserRequestDTO dto) {
        UserResponseDTO response = userService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Retorna lista de todos os Usuários", method = "GET")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listar() {
        List<UserResponseDTO> lista = userService.listarTodos();
        return ResponseEntity.ok(lista);
    }
}
