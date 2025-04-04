package com.Thiago279.agendamento_medico.service;

import com.Thiago279.agendamento_medico.dto.ClientRequestDTO;
import com.Thiago279.agendamento_medico.dto.ClientUpdateDTO;
import com.Thiago279.agendamento_medico.entity.Client;

import java.util.List;

public interface IClientService {

    public List<Client> listAll();

    public Client registerClient(ClientRequestDTO dto);

    public void delete(Long id);

    public Client update(Long id, ClientUpdateDTO dto);
}
