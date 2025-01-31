package com.barberflow.barberflow.customer.dto.mapper;

import com.barberflow.barberflow.customer.dto.signup.CustomerSignupReceiveDto;
import com.barberflow.barberflow.customer.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-31T14:20:07-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer signupDtoToCustomer(CustomerSignupReceiveDto dto) {
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
}
