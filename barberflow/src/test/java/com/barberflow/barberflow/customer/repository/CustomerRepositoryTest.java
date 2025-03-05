package com.barberflow.barberflow.customer.repository;

import com.barberflow.barberflow.customer.entity.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repository;

    @BeforeEach
    void setUp(){
        Customer customer = new Customer(
                "john doe",
                "john@email.com",
                "12345678aA!",
                "12121212121"
        );
        repository.save(customer);
    }

    @Test
    void findByName_existingUsername_returnSavedCustomer(){
        Customer saved = repository.findByName("john doe").orElse(null);

        Assertions.assertThat(saved.getId()).isEqualTo(1L);
        Assertions.assertThat(saved.getName()).isEqualTo("john doe");
        Assertions.assertThat(saved.getPassword()).isEqualTo("12345678aA!");
        Assertions.assertThat(saved.getPhoneNumber()).isEqualTo("12121212121");
    }

    @Test
    void findByName_notExistingUsername_returnNull(){
        Customer saved = repository.findByName("not existing").orElse(null);

        Assertions.assertThat(saved).isNull();
    }

    @Test
    void findByName_nullInput_returnNull(){
        Customer saved = repository.findByName(null).orElse(null);

        Assertions.assertThat(saved).isNull();
    }
}
