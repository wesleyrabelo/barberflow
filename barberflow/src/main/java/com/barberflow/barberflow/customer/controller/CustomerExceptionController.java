package com.barberflow.barberflow.customer.controller;

import com.barberflow.barberflow.customer.exception.CustomerExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Objects;

@RestControllerAdvice("com.barberflow.barberflow.customer")
public class CustomerExceptionController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomerExceptionResponse> entityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                    new CustomerExceptionResponse(
                            exception.getClass().getSimpleName(),
                            exception.getMessage(),
                            LocalDateTime.now(),
                            HttpStatus.NOT_FOUND)
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomerExceptionResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        return ResponseEntity
                .badRequest()
                .body(
                    new CustomerExceptionResponse(
                            exception.getClass().getSimpleName(),
                            Objects.requireNonNull(exception.getFieldError()).getDefaultMessage(),
                            LocalDateTime.now(),
                            HttpStatus.BAD_REQUEST
                    )
        );
    }
}
