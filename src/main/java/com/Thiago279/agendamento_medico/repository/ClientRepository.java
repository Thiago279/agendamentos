package com.Thiago279.agendamento_medico.repository;

import com.Thiago279.agendamento_medico.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client, Long>{

    public Optional<Client> findByNameAndEmailAndPhoneNumber(String name, String email, String phoneNumber);
}
