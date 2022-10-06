package br.com.clinica.config;

import br.com.clinica.exeption.MedicoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@RestController
@ControllerAdvice
public class Handler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = MedicoNaoEncontradoException.class)
    public ResponseEntity<DefaultError> medicoNaoEncontradoException() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DefaultError
                        .builder()
                        .msg("medico não encontrado")
                        .build());
    }
}
