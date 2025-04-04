package com.Thiago279.agendamento_medico.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }
}
