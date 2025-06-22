package com.example.InstaRide.service;

import com.example.InstaRide.dto.request.DriverRequest;
import com.example.InstaRide.dto.response.DriverResponse;
import com.example.InstaRide.model.Driver;
import com.example.InstaRide.repository.DriverRepository;
import com.example.InstaRide.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {

        Driver driver = DriverTransformer.driverRequestToDriver(driverRequest);
        Driver savedDriver = driverRepository.save(driver);
        return DriverTransformer.driverToDriverResponse(savedDriver);
    }
}
