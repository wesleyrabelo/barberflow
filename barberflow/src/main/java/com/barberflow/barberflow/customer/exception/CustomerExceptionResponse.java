package com.barberflow.barberflow.customer.exception;

import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public class CustomerExceptionResponse {
    public String name;
    public String cause;
    public LocalDateTime timestamp;
    public HttpStatusCode status;

    public CustomerExceptionResponse(String name, String cause, LocalDateTime timestamp, HttpStatusCode status) {
        this.name = name;
        this.cause = cause;
        this.timestamp = timestamp;
        this.status = status;
    }
}
