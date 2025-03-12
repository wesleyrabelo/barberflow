package com.barberflow.barberflow.customer.service;

import com.barberflow.barberflow.customer.dto.mapper.CustomerMapper;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupResponseDto;
import com.barberflow.barberflow.customer.entity.Customer;
import com.barberflow.barberflow.customer.repository.CustomerRepository;
import com.barberflow.barberflow.customer.service.impl.CustomerServiceImpl;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomerServiceTest {
    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerServiceImpl service;

    @Autowired
    private CustomerMapper mapper;

    @BeforeEach
    void setUp(){
        service = new CustomerServiceImpl(repository, mapper);
    }

    @Test
    void saveCustomer_validCustomerSignupReceiveDto_returnCustomerSignupResponseDto(){
        CustomerSignupReceiveDto dto = new CustomerSignupReceiveDto(
                "john doe",
                "john@email.com",
                "12345678aA!",
                "12121212121"
        );

        Customer savedCustomer = new Customer(
                "john doe",
                "john@email.com",
                "12345678aA!",
                "12121212121"
        );
        savedCustomer.setId(1L);

        Mockito.when(repository.save(Mockito.any(Customer.class))).thenReturn(savedCustomer);

        CustomerSignupResponseDto savedDto = service.saveCustomer(dto);
        Assertions.assertThat(savedDto.id).isEqualTo(1L);
        Assertions.assertThat(savedDto.email).isEqualTo("john@email.com");
    }
}
