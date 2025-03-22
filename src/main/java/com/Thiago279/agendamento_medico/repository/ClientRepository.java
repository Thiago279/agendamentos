package com.Thiago279.agendamento_medico.repository;

import com.Thiago279.agendamento_medico.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long>{
}
