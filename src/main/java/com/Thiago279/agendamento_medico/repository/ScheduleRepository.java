package com.Thiago279.agendamento_medico.repository;

import com.Thiago279.agendamento_medico.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository <Schedule, Long> {
}
