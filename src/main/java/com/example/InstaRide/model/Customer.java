package com.example.InstaRide.model;


import com.example.InstaRide.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor          //default constructor
@AllArgsConstructor         //generates all agrument constructors
@Getter
@Setter
@Entity
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;
    @Column(unique = true, nullable = false)
    private String emailId;


    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "customer_id")
    List<Booking> bookings = new ArrayList<>();

}
