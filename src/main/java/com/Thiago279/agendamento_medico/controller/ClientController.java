package com.Thiago279.agendamento_medico.controller;

import com.Thiago279.agendamento_medico.dto.ClientRequestDTO;
import com.Thiago279.agendamento_medico.entity.Client;
import com.Thiago279.agendamento_medico.entity.Schedule;
import com.Thiago279.agendamento_medico.service.impl.ClientService;
import com.Thiago279.agendamento_medico.service.impl.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService service;

    public ClientController( ClientService service ){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Client>> listSchedules(){
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    public ResponseEntity<ClientRequestDTO> registerClient(@RequestBody ClientRequestDTO dto){
        service.registerClient(dto);
        return ResponseEntity.ok(dto);
    }
}
