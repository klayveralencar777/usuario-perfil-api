package br.com.usuario_perfil.UsuarioPerfilApi.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataViolation(DataIntegrityViolationException ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<String> emailExists(EmailAlreadyExistsException ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }

    public ResponseEntity<String> userPerfilIsNull(UserPerfilIsNullException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> genericException(Exception ex) {
        return ResponseEntity.status(500).body("Erro interno no servidor!");
    }
    
}
