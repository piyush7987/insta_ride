package com.example.InstaRide.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "driver")
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private int driverId;

    @Column(name = "name")
    private String name;
    private int age;

    @Column(unique = true, nullable = false)    //make unique values & nullable for not null
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    List<Booking> bookings = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_id")
    Cab cab;

}
