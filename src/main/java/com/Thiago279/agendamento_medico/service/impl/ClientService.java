package com.Thiago279.agendamento_medico.service.impl;

import com.Thiago279.agendamento_medico.dto.ClientRequestDTO;
import com.Thiago279.agendamento_medico.dto.ClientUpdateDTO;
import com.Thiago279.agendamento_medico.entity.Client;
import com.Thiago279.agendamento_medico.entity.Schedule;
import com.Thiago279.agendamento_medico.exceptions.ClienteNaoEncontradoException;
import com.Thiago279.agendamento_medico.exceptions.OperacaoNaoPermitidaException;
import com.Thiago279.agendamento_medico.repository.ClientRepository;
import com.Thiago279.agendamento_medico.repository.ScheduleRepository;
import com.Thiago279.agendamento_medico.service.IClientService;
import com.Thiago279.agendamento_medico.validator.ClientValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    @Autowired
    ClientRepository repository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    ClientValidator validator;

    @Override
    public List<Client> listAll() {
        return repository.findAll();
    }

    @Override
    public Client registerClient(ClientRequestDTO dto) {

        Client client = new Client();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhoneNumber(dto.getPhoneNumber());
        validator.validar(client);
        return repository.save(client);
    }

    @Override
    public void delete(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () ->
                new ClienteNaoEncontradoException(
                        "Não existe nenhum cliente reistrado com esse id"
                ));
        if (hasAppointment(client)){
            throw new OperacaoNaoPermitidaException(
                    "Não é permitido excluir um cliente que possui consulta agendada!");
        }
        repository.delete(client);
    }

    @Override
    public Client update(Long id, ClientUpdateDTO dto) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ClienteNaoEncontradoException("Cliente não encontrado com ID: " + id)
        );

        if (dto.email() == null && dto.phoneNumber() == null){
            throw new OperacaoNaoPermitidaException("Não é permitido cliente sem email ou telefone");
        }

        if (dto.email() != null) {
            client.setEmail(dto.email());
        }

        if (dto.phoneNumber() != null) {
            client.setPhoneNumber(dto.phoneNumber());
        }

        return repository.save(client);
    }

    public boolean hasAppointment(Client client){
        return scheduleRepository.existsByClient(client);
    }
}
