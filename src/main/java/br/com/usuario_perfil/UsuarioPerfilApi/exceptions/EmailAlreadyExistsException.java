package br.com.usuario_perfil.UsuarioPerfilApi.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
 
}

