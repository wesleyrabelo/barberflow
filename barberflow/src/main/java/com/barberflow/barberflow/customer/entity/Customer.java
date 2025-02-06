package com.barberflow.barberflow.customer.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

//TO-DO:
//  Criar a classe Appointment

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome não pode ser vazio ou nulo")
    @Size(min = 6, max = 20, message = "Tamanho do nome deve ser entre 6 e 20 caracteres")
    @Pattern(regexp = "^[a-zA-Z ,.'-]+$", message = "Nome deve conter somente letras")
    private String name;
    @Column(unique = true)
    @NotBlank(message = "Email não pode ser vazio ou nulo")
    @Pattern(regexp = "^[a-z0-9.]+@[a-z0-9]+\\.[a-z]+(\\.[a-z]+)?$", message = "Deve ser um email válido")
    private String email;
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Senha inválida")
    private String password;
    @Column(unique = true)
    @Nullable
    @Pattern(regexp = "^[1-9][1-9][0-9]{9}$", message = "Número de telefone inválido")
    private String phoneNumber;
    @Column(updatable = false)
    private final LocalDateTime creationDate = LocalDateTime.now();
    //private List<Appointment> appointments;
    public Customer(){}

    public Customer(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}
