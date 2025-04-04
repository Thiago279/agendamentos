package com.Thiago279.agendamento_medico.controller;

import com.Thiago279.agendamento_medico.dto.ClientRequestDTO;
import com.Thiago279.agendamento_medico.dto.ClientUpdateDTO;
import com.Thiago279.agendamento_medico.dto.ErroResposta;
import com.Thiago279.agendamento_medico.dto.ScheduleUpdateDTO;
import com.Thiago279.agendamento_medico.entity.Client;
import com.Thiago279.agendamento_medico.entity.Schedule;
import com.Thiago279.agendamento_medico.exceptions.ClienteNaoEncontradoException;
import com.Thiago279.agendamento_medico.exceptions.OperacaoNaoPermitidaException;
import com.Thiago279.agendamento_medico.exceptions.RegistroDuplicadoException;
import com.Thiago279.agendamento_medico.service.impl.ClientService;
import com.Thiago279.agendamento_medico.service.impl.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService service;

    public ClientController( ClientService service ){
        this.service = service;
    }

    @Operation(summary = "Retorna lista de todos os clientes", method = "GET")
    @GetMapping
    public ResponseEntity<List<Client>> listSchedules(){
        return ResponseEntity.ok(service.listAll());
    }

    @Operation(summary = "Registra cliente (nome, email , numero de telefone)", method = "POST")
    @PostMapping
    public ResponseEntity<Object> registerClient(@RequestBody ClientRequestDTO dto){
        try{
        service.registerClient(dto);
        return ResponseEntity.ok(dto);
    } catch (RegistroDuplicadoException e){
            var erroDto = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }

    @Operation(summary = "Deleta cliente (id)", method = "DELETE")
    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id ){
        try{
        service.delete(id);
        return ResponseEntity.noContent().build();
    } catch (OperacaoNaoPermitidaException | ClienteNaoEncontradoException e){
            var erroDto = ErroResposta.respostaPadrao(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }

    @Operation(summary = "atualiza dados do cliente (id)", method = "PUT")
    @PutMapping("{id}")
    public ResponseEntity<Object> updateSchedule(@PathVariable Long id , @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Objeto contendo o novo telefone e/ou email do cliente",
            content = @io.swagger.v3.oas.annotations.media.Content(
                    schema = @Schema(implementation = ClientUpdateDTO.class)
            )
    ) @Valid ClientUpdateDTO schedule) {
        try {
            return ResponseEntity.ok(service.update(id, schedule));
        } catch (ClienteNaoEncontradoException | OperacaoNaoPermitidaException e) {
            var erroDto= ErroResposta.respostaPadrao(e.getMessage());
            return ResponseEntity.status(erroDto.status()).body(erroDto);
        }
    }

}
