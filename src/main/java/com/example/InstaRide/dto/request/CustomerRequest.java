package com.example.InstaRide.dto.request;

import com.example.InstaRide.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {    //input

    private String name;

    private int age;

    private String emailId;

    private Gender gender;


}
