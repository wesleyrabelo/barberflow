package com.barberflow.barberflow.customer.dto.signup;

//TO-DO: Adicionar as restrições na criação do campo
public class CustomerSignupReceiveDto {
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
