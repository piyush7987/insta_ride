package com.example.InstaRide.controller;

import com.example.InstaRide.dto.request.BookingRequest;
import com.example.InstaRide.dto.response.BookingResponse;
import com.example.InstaRide.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/book/customer/{customerid}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @PathVariable("customerid") int customerId){

        return bookingService.bookcab(bookingRequest,customerId);

    }

}
