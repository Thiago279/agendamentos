package com.Thiago279.agendamento_medico.service.impl;

import com.Thiago279.agendamento_medico.dto.ClientRequestDTO;
import com.Thiago279.agendamento_medico.entity.Client;
import com.Thiago279.agendamento_medico.repository.ClientRepository;
import com.Thiago279.agendamento_medico.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    ClientRepository repository;
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
        return repository.save(client);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
