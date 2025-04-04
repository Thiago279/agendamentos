package com.Thiago279.agendamento_medico.service.impl;

import com.Thiago279.agendamento_medico.dto.ScheduleRequestDTO;
import com.Thiago279.agendamento_medico.dto.ScheduleUpdateDTO;
import com.Thiago279.agendamento_medico.entity.Client;
import com.Thiago279.agendamento_medico.entity.Schedule;
import com.Thiago279.agendamento_medico.exceptions.ClienteNaoEncontradoException;
import com.Thiago279.agendamento_medico.repository.ClientRepository;
import com.Thiago279.agendamento_medico.repository.ScheduleRepository;
import com.Thiago279.agendamento_medico.service.IScheduleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService implements IScheduleService {

    @Autowired
    ScheduleRepository repository;

    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<Schedule> listAll() {
        return repository.findAll();
    }

    @Override
    public Schedule save(ScheduleRequestDTO dto) {
        Schedule schedule = new Schedule();
        Client client = (clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente não encontrado com ID: " + dto.clientId())));
        schedule.setClient(client);
        schedule.setStartDate(dto.startDate());
        schedule.setEndDate(dto.startDate().plusMinutes(30));
        return repository.save(schedule);
    }


    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }

    public Schedule update(Long id, ScheduleUpdateDTO dto){
        Schedule schedule = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Agendamento não encontrado com ID: " + id)
        );

        schedule.setStartDate(dto.startDate());
        schedule.setEndDate(dto.startDate().plusMinutes(30));
        return repository.save(schedule);
    }
}
