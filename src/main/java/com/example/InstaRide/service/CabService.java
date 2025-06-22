package com.example.InstaRide.service;

import com.example.InstaRide.dto.request.CabRequest;
import com.example.InstaRide.dto.response.CabResponse;
import com.example.InstaRide.exception.DriverNotFoundException;
import com.example.InstaRide.model.Cab;
import com.example.InstaRide.model.Driver;
import com.example.InstaRide.repository.DriverRepository;
import com.example.InstaRide.transformer.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    DriverRepository driverRepository;


    public CabResponse registerCab(CabRequest cabRequest, int driverId) {
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid Driver Id");
        }

        Driver driver = optionalDriver.get();
        Cab cab = CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);

        Driver savedDriver = driverRepository.save(driver); // save both driver & cab

        return CabTransformer.cabToCabResponse(savedDriver.getCab(),savedDriver);
    }

}
