package com.example.InstaRide.controller;


import com.example.InstaRide.dto.request.CabRequest;
import com.example.InstaRide.dto.response.CabResponse;
import com.example.InstaRide.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    CabService cabService;


    @PostMapping("/register/driver/{driverid}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest,
                                   @PathVariable("driverid") int driverId){

        return cabService.registerCab(cabRequest,driverId);
    }
}
