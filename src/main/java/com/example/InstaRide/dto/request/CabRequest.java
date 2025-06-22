package com.example.InstaRide.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CabRequest {

    private String cabNumber;

    private String cabModel;

    private double perKmRate;
}
