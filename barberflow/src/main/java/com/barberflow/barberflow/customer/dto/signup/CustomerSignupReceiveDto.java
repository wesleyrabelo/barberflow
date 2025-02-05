package com.barberflow.barberflow.customer.dto.signup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//TO-DO: Adicionar as restrições na criação do campo
public class CustomerSignupReceiveDto {
    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    @Size(min = 6, max = 20, message = "Tamanho do nome deve ser entre 6 e 20 caracteres")
    @Pattern(regexp = "^[a-z ,.'-]+$", message = "Nome deve conter somente letras")
    public String name;
    public String email;
    public String password;
    public String phoneNumber;

    public CustomerSignupReceiveDto(String name, String email, String password, String phoneNumber) {
        this.name = name.trim();
        this.email = email.trim();
        this.password = password;
        this.phoneNumber = phoneNumber.trim();
    }
}
