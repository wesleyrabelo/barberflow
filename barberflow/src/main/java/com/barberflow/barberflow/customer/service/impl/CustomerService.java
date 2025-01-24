package com.barberflow.barberflow.customer.service;

import com.barberflow.barberflow.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    //Apesar da anotação @RequiredArgsContrutor do Lombok suportar o uso de @Autowired  é experimental.
    //Mesmo que o Spring não precise da anotação @Autowired quando é apenas um campo no construtor,
    //é bem provável que no futuro haja mais de um. Por isso dá escolha de explicitamente criar o
    //construtor e colocar a @Autowired. Do contrário, bastaria adicionar @RequiredArgsConstructor.
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer 
}
