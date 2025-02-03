package com.barberflow.barberflow.customer.service;


import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupResponseDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateReceiveDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateResponseDto;
import com.barberflow.barberflow.customer.entity.Customer;
//TO-DO
//  Fazer o metodo @updateCustomer receber um Dto
public interface CustomerService {
    CustomerSignupResponseDto saveCustomer(CustomerSignupReceiveDto dto);
    CustomerUpdateResponseDto updateCustomer(Long id, CustomerUpdateReceiveDto dto);
    void deleteCustomer(Long id);
    Customer findById(Long id);
    Customer findByEmail(String email);
}
