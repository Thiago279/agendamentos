package com.Thiago279.agendamento_medico.validator;

import com.Thiago279.agendamento_medico.entity.Client;
import com.Thiago279.agendamento_medico.exceptions.RegistroDuplicadoException;
import com.Thiago279.agendamento_medico.repository.ClientRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientValidator {

    ClientRepository repository;

    public ClientValidator(ClientRepository repository) {
        this.repository = repository;
    }

    public void validar(Client client){
        if (clientExists(client)){
            throw new RegistroDuplicadoException("Cliente ja cadastrado");
        }
    }

    private boolean clientExists(Client client){
        Optional<Client> clientFound = repository.findByNameAndEmailAndPhoneNumber(
                client.getName(),
                client.getEmail(),
                client.getPhoneNumber()
        );
        if(client.getId() == null){
            return clientFound.isPresent();
        }
        return !client.getId().equals(clientFound.get().getId()) && clientFound.isPresent();

    }
}
