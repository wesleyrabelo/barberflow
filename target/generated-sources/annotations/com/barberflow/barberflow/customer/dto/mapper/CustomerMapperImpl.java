package com.barberflow.barberflow.customer.dto.mapper;

import com.barberflow.barberflow.customer.dto.find.CustomerFindByIdResponseDto;
import com.barberflow.barberflow.customer.dto.find.CustomerFindByNameResponseDto;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.dto.signup.CustomerSignupResponseDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateReceiveDto;
import com.barberflow.barberflow.customer.dto.update.CustomerUpdateResponseDto;
import com.barberflow.barberflow.customer.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-12T17:20:28-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerReceiveDtoToCustomer(CustomerSignupReceiveDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( dto.name );
        customer.setEmail( dto.email );
        customer.setPassword( dto.password );
        customer.setPhoneNumber( dto.phoneNumber );

        return customer;
    }

    @Override
    public CustomerSignupResponseDto customerToSignupResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerSignupResponseDto customerSignupResponseDto = new CustomerSignupResponseDto();

        customerSignupResponseDto.id = customer.getId();
        customerSignupResponseDto.name = customer.getName();
        customerSignupResponseDto.email = customer.getEmail();
        customerSignupResponseDto.creationDate = customer.getCreationDate();

        return customerSignupResponseDto;
    }

    @Override
    public Customer updateCustomerFromDto(CustomerUpdateReceiveDto dto, Customer customer) {
        if ( dto == null ) {
            return customer;
        }

        if ( dto.name != null ) {
            customer.setName( dto.name );
        }
        if ( dto.email != null ) {
            customer.setEmail( dto.email );
        }
        if ( dto.password != null ) {
            customer.setPassword( dto.password );
        }
        if ( dto.phoneNumber != null ) {
            customer.setPhoneNumber( dto.phoneNumber );
        }

        return customer;
    }

    @Override
    public CustomerUpdateResponseDto customerToUpdateResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerUpdateResponseDto customerUpdateResponseDto = new CustomerUpdateResponseDto();

        customerUpdateResponseDto.name = customer.getName();
        customerUpdateResponseDto.email = customer.getEmail();
        customerUpdateResponseDto.password = customer.getPassword();
        customerUpdateResponseDto.phoneNumber = customer.getPhoneNumber();

        return customerUpdateResponseDto;
    }

    @Override
    public CustomerFindByIdResponseDto customerToCustomerFindByIdResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerFindByIdResponseDto customerFindByIdResponseDto = new CustomerFindByIdResponseDto();

        customerFindByIdResponseDto.name = customer.getName();
        customerFindByIdResponseDto.email = customer.getEmail();
        customerFindByIdResponseDto.password = customer.getPassword();
        customerFindByIdResponseDto.phoneNumber = customer.getPhoneNumber();
        customerFindByIdResponseDto.creationDate = customer.getCreationDate();

        return customerFindByIdResponseDto;
    }

    @Override
    public CustomerFindByNameResponseDto customerToCustomerFindByNameResponseDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerFindByNameResponseDto customerFindByNameResponseDto = new CustomerFindByNameResponseDto();

        customerFindByNameResponseDto.name = customer.getName();
        customerFindByNameResponseDto.email = customer.getEmail();
        customerFindByNameResponseDto.password = customer.getPassword();
        customerFindByNameResponseDto.phoneNumber = customer.getPhoneNumber();
        customerFindByNameResponseDto.creationDate = customer.getCreationDate();

        return customerFindByNameResponseDto;
    }
}
