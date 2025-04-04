package com.Thiago279.agendamento_medico.exceptions;

public class RegistroDuplicadoException extends RuntimeException{

    public RegistroDuplicadoException(String message ){
        super (message);
    }
}
