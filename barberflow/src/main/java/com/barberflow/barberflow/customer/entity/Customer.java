package com.barberflow.barberflow.customer.entity;

import com.barberflow.barberflow.appointment.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private List<Appointment> appointments;
}
