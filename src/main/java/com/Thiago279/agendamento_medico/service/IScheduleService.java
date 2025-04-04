package com.Thiago279.agendamento_medico.service;

import com.Thiago279.agendamento_medico.dto.ScheduleRequestDTO;
import com.Thiago279.agendamento_medico.dto.ScheduleUpdateDTO;
import com.Thiago279.agendamento_medico.entity.Schedule;

import java.util.List;

public interface IScheduleService {

    public List<Schedule> listAll();

    Schedule save(ScheduleRequestDTO schedule);

    public void delete( Long id);

    public Schedule update(Long id, ScheduleUpdateDTO dto);
}
