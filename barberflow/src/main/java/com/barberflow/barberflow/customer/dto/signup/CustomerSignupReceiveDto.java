package com.barberflow.barberflow.customer.dto.signup;

import jakarta.validation.constraints.NotBlank;

//TO-DO: Adicionar as restrições na criação do campo
public class CustomerSignupReceiveDto {
    @NotBlank
    public String name;
    public String email;
    public String password;
    public String phoneNumber;

    public CustomerSignupReceiveDto(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
