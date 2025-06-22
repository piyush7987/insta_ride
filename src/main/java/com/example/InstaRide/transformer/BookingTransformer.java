package com.example.InstaRide.transformer;

import com.example.InstaRide.Enum.TripStatus;
import com.example.InstaRide.dto.request.BookingRequest;
import com.example.InstaRide.dto.response.BookingResponse;
import com.example.InstaRide.model.Booking;
import com.example.InstaRide.model.Cab;
import com.example.InstaRide.model.Customer;
import com.example.InstaRide.model.Driver;

public class BookingTransformer {

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, double perKmRate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripStatus(TripStatus.In_PROGRESS)
                .billAmount(bookingRequest.getTripDistanceInKm()*perKmRate)
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking, Customer customer,
                                                           Cab cab, Driver driver){
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripStatus(booking.getTripStatus())
                .billAmount(booking.getBillAmount())
                .bookedAt(booking.getBookedAt())
                .lastUpdateAt(booking.getLastUpdateAt())
                .customer(CustomerTransformer.customerToCustomerResponse(customer))
                .cab(CabTransformer.cabToCabResponse(cab, driver))
                .build();
    }
}
