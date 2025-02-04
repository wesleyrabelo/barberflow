package com.barberflow.barberflow.customer.controller;

import com.barberflow.barberflow.customer.exception.CustomerExceptionResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice("com.barberflow.barberflow.customer")
public class CustomerExceptionController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomerExceptionResponse> entityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new CustomerExceptionResponse(
                        exception.getClass().getSimpleName(),
                        exception.getMessage(),
                        LocalDateTime.now(),
                        HttpStatus.NOT_FOUND)
        );
    }
}
