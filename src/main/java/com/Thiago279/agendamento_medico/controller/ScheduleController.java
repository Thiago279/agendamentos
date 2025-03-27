package com.Thiago279.agendamento_medico.controller;


import com.Thiago279.agendamento_medico.dto.ScheduleRequestDTO;
import com.Thiago279.agendamento_medico.entity.Schedule;
import com.Thiago279.agendamento_medico.service.impl.ClientService;
import com.Thiago279.agendamento_medico.service.impl.ScheduleService;
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

    @GetMapping
    public ResponseEntity<List<Schedule>> listSchedules(){
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    public ResponseEntity<Schedule> saveSchedule(@RequestBody @Valid ScheduleRequestDTO schedule){
        return ResponseEntity.ok(service.save(schedule));
    }
}
