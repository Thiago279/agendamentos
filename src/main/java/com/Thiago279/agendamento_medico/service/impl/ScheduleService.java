package com.Thiago279.agendamento_medico.service.impl;

import com.Thiago279.agendamento_medico.entity.Schedule;
import com.Thiago279.agendamento_medico.repository.ScheduleRepository;
import com.Thiago279.agendamento_medico.service.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    ScheduleRepository repository;
    @Override
    public List<Schedule> listAll() {
        return repository.findAll();
    }
}
