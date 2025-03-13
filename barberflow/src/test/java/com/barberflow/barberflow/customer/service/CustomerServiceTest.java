package com.barberflow.barberflow.customer.service;

import com.barberflow.barberflow.customer.dto.find.CustomerFindByIdResponseDto;
import com.barberflow.barberflow.customer.dto.mapper.CustomerMapper;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupResponseDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateReceiveDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateResponseDto;
import com.barberflow.barberflow.customer.entity.Customer;
import com.barberflow.barberflow.customer.repository.CustomerRepository;
import com.barberflow.barberflow.customer.service.impl.CustomerServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static java.util.function.Predicate.not;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        Assertions.assertThat(savedDto)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", "john doe")
                .hasFieldOrPropertyWithValue("email", "john@email.com");
    }

    @Test
    void updateCustomer_existingCustomerUpdateReceiveDto_returnCustomerUpdateResponseDto(){
        Customer savedCustomer = new Customer(
                "john doe",
                "john@email.com",
                "12345678aA!",
                "12121212121"
        );
        savedCustomer.setId(1L);

        CustomerUpdateReceiveDto receiveDto = new CustomerUpdateReceiveDto();
        receiveDto.name = "updated updated";
        receiveDto.email = "update@email.com";
        receiveDto.password = "Updated123@";
        receiveDto.phoneNumber = "333333333";

        Customer updatedCustomer = new Customer(
                "updated updated",
                "update@email.com",
                "Updated123@",
                "333333333"
        );
        updatedCustomer.setId(1L);

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(savedCustomer));
        Mockito.when(repository.save(Mockito.any(Customer.class))).thenReturn(updatedCustomer);

        CustomerUpdateResponseDto customer = service.updateCustomer(1L, receiveDto);

        Assertions.assertThat(customer)
                .hasFieldOrPropertyWithValue("name", "updated updated")
                .hasFieldOrPropertyWithValue("email", "update@email.com")
                .hasFieldOrPropertyWithValue("phoneNumber", "333333333");
    }

    @Test
    void updateCustomer_inexistentCustomer_throwEntityNotFoundException(){
        Mockito.when(repository.findById(1L)).thenThrow(new EntityNotFoundException());

        assertThrows(EntityNotFoundException.class, () -> service.updateCustomer(1L, Mockito.mock(CustomerUpdateReceiveDto.class)));
    }

    @Test
    void deleteCustomer_existingCustomer_returnVoid(){
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(Mockito.mock(Customer.class)));

        service.deleteCustomer(1L);

        Mockito.verify(repository).deleteById(1L);
    }

    @Test
    void deleteCustomer_inexistentCustomer_throwEntityNotFoundException(){
        Mockito.when(repository.findById(1L)).thenThrow(new EntityNotFoundException());

        assertThrows(EntityNotFoundException.class, () -> service.deleteCustomer(1L));
    }

    @Test
    void findById_existingCustomer_returnCustomerFindByIdResponseDto(){
        Customer savedCustomer = new Customer(
                "john doe",
                "john@email.com",
                "12345678aA!",
                "12121212121"
        );
        savedCustomer.setId(1L);

        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(savedCustomer));

        CustomerFindByIdResponseDto customer = service.findById(1L);

        Assertions.assertThat(customer)
                .hasFieldOrPropertyWithValue("name", "john doe")
                .hasFieldOrPropertyWithValue("email", "john@email.com" )
                .hasFieldOrPropertyWithValue("phoneNumber", "12121212121")
                .extracting("creationDate").isNotNull();
    }
}
