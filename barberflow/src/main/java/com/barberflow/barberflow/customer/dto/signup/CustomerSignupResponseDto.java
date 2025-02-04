package com.barberflow.barberflow.customer.dto.signup;

import java.time.LocalDateTime;

//Adicionar as restrições nos campos
public class CustomerSignupResponseDto {
    public Long id;
    public String name;
    public String email;
    public LocalDateTime creationDate;
}
