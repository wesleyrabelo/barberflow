package com.barberflow.barberflow.customer.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.barberflow.barberflow.customer")
public class CustomerExceptionController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(exception.getMessage());
    }
}
