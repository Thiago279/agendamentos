package com.Thiago279.agendamento_medico.controller;


import com.Thiago279.agendamento_medico.dto.ErroResposta;
import com.Thiago279.agendamento_medico.dto.ScheduleRequestDTO;
import com.Thiago279.agendamento_medico.dto.ScheduleUpdateDTO;
import com.Thiago279.agendamento_medico.entity.Schedule;
import com.Thiago279.agendamento_medico.service.impl.ClientService;
import com.Thiago279.agendamento_medico.service.impl.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schedules")
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController( ScheduleService service ){
        this.service = service;
    }

    @Operation(summary = "Retorna lista de todos os agendamentos", method = "GET")
    @GetMapping
    public ResponseEntity<List<Schedule>> listSchedules(){
        return ResponseEntity.ok(service.listAll());
    }

    @Operation(summary = "Cadastra agendamento de consulta", method = "POST")
    @ApiResponse(responseCode = "409", description = "Cliente ja cadastrado")
    @PostMapping
    public ResponseEntity<Schedule> saveSchedule(@RequestBody @Valid ScheduleRequestDTO schedule){
        return ResponseEntity.ok(service.save(schedule));
    }

    @Operation(summary = "Deleta agendamento de consulta", method = "DELETE")
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteSchedule(@PathVariable Long id ){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "atualiza data de agendamento de consulta (id)", method = "PUT")
    @PutMapping("{id}")
    public ResponseEntity<Object> updateSchedule(@PathVariable Long id , @RequestBody @Valid ScheduleUpdateDTO schedule) {
        try {
            return ResponseEntity.ok(service.update(id, schedule));
        } catch (EntityNotFoundException e) {
            var erroDto= ErroResposta.respostaPadrao(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }
}
