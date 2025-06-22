package com.example.InstaRide.dto.response;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {   //output

    private String name;
    private int age;
    private String emailId;
}
