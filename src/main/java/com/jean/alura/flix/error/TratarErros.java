package com.jean.alura.flix.error;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class TratarErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity videoNaoEncontrado(){
        return ResponseEntity.badRequest().body("Id não encontrado");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity camposInvalidos(MethodArgumentNotValidException e){
        List<FieldError> error = e.getFieldErrors();

        return ResponseEntity.badRequest().body(error.stream().map(DadosErro::new));
    }

    private record DadosErro(String erro, String mensagem){
        public DadosErro(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }
    }
}
