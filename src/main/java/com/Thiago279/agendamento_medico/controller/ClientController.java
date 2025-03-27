package com.Thiago279.agendamento_medico.controller;

import com.Thiago279.agendamento_medico.dto.ClientRequestDTO;
import com.Thiago279.agendamento_medico.entity.Client;
import com.Thiago279.agendamento_medico.entity.Schedule;
import com.Thiago279.agendamento_medico.service.impl.ClientService;
import com.Thiago279.agendamento_medico.service.impl.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService service;

    public ClientController( ClientService service ){
        this.service = service;
    }

    @Operation(summary = "Retorna lista de todos os clientes", method = "GET")
    @GetMapping
    public ResponseEntity<List<Client>> listSchedules(){
        return ResponseEntity.ok(service.listAll());
    }

    @Operation(summary = "Registra cliente (nome, email , numero de telefone)", method = "POST")
    @PostMapping
    public ResponseEntity<ClientRequestDTO> registerClient(@RequestBody ClientRequestDTO dto){
        service.registerClient(dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Deleta cliente (id)", method = "DELETE")
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id ){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
