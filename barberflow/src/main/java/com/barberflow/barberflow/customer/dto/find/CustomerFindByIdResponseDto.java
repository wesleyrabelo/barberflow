package com.barberflow.barberflow.customer.dto.find;

import java.time.LocalDateTime;

//TO-DO: Adicionar os Appointments quando eles forem criados
public class CustomerFindByIdResponseDto {
    public String name;
    public String email;
    public String password;
    public String phoneNumber;
    public LocalDateTime creationDate;
}
