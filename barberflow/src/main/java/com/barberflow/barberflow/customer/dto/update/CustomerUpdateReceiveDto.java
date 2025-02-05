package com.barberflow.barberflow.customer.dto.update;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//TO-DO: Adicionar restrições? - Adicionar os Appointments quando eles forem criados
public class CustomerUpdateReceiveDto {
    @Nullable
    @Size(min = 6, max = 20, message = "Tamanho do nome deve ser entre 6 e 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "Nome deve conter somente letras")
    public String name;
    @Nullable
    @Pattern(regexp = "^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+(\\.[a-z]+)?$", message = "Deve ser um email válido")
    public String email;
    @Nullable
    @Size(max = 15, message = "Tamanho máximo é 15 caracteres")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Senha inválida")
    public String password;
    @Nullable
    @Pattern(regexp = "^[1-9][1-9][0-9]{9}$", message = "Número de telefone inválido")
    public String phoneNumber;
}
