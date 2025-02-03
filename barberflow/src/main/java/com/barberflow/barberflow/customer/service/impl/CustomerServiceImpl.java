package com.barberflow.barberflow.customer.service.impl;

import com.barberflow.barberflow.customer.dto.find.CustomerFindByIdResponseDto;
import com.barberflow.barberflow.customer.dto.mapper.CustomerMapper;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupResponseDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateReceiveDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateResponseDto;
import com.barberflow.barberflow.customer.entity.Customer;
import com.barberflow.barberflow.customer.repository.CustomerRepository;
import com.barberflow.barberflow.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TO-DO:
//  Criar uma exceção personalizada para os metodos @deleteCustomer, @findById e @findByEmail.
//  Melhorar a logica do metodo @updateCustomer
//  Verificar se criar o metodo internalFindById é uma boa ideia mesmo

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper mapper){
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public CustomerSignupResponseDto saveCustomer(CustomerSignupReceiveDto dto) {
        Customer customer = mapper.customerReceiveDtoToCustomer(dto);
        Customer saved = customerRepository.save(customer);
        return mapper.customerToSignupResponseDto(saved);
    }

    @Override
    public CustomerUpdateResponseDto updateCustomer(Long id, CustomerUpdateReceiveDto dto) {
      Customer saved = internalFindById(id);
      Customer updated = mapper.updateCustomerFromDto(dto, saved);
      Customer customer = customerRepository.save(updated);
      return mapper.customerToUpdateResponseDto(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer saved = internalFindById(id);
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerFindByIdResponseDto findById(Long id) {
        Customer saved = customerRepository.findById(id).orElseThrow(
                RuntimeException::new
        );
        return mapper.customerToCustomerFindByIdResponseDto(saved);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }

    private Customer internalFindById(Long id){
        return customerRepository.findById(id).orElseThrow(
                RuntimeException::new
        );
    }
}
