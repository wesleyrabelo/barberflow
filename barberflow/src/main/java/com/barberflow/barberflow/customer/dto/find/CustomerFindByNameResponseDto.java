package com.barberflow.barberflow.customer.dto.find;

import java.time.LocalDateTime;

//Adicionar os appointments quando criados
public class CustomerFindByNameResponseDto {
    public String name;
    public String email;
    public String password;
    public String phoneNumber;
    public LocalDateTime creationDate;
}
