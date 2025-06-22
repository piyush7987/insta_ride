package com.example.InstaRide.service;

import com.example.InstaRide.dto.request.BookingRequest;
import com.example.InstaRide.dto.response.BookingResponse;
import com.example.InstaRide.exception.CabUnavailableException;
import com.example.InstaRide.exception.CustomerNotFoundException;
import com.example.InstaRide.model.Booking;
import com.example.InstaRide.model.Cab;
import com.example.InstaRide.model.Customer;
import com.example.InstaRide.model.Driver;
import com.example.InstaRide.repository.BookingRepository;
import com.example.InstaRide.repository.CabRepository;
import com.example.InstaRide.repository.CustomerRepository;
import com.example.InstaRide.repository.DriverRepository;
import com.example.InstaRide.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    DriverRepository driverRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    JavaMailSender javaMailSender;


    public BookingResponse bookcab(BookingRequest bookingRequest, int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer Id");
        }

        Customer customer = optionalCustomer.get();
        Cab availableCab  = cabRepository.getAvailableCabRandom();
        if (availableCab ==null){
            throw new CabUnavailableException("Sorry No cabs available");
        }

        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest, availableCab.getPerKmRate());
        Booking savedBooking = bookingRepository.save(booking);

        availableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);

        Driver driver = driverRepository.getDriverByCabId(availableCab.getCabId());
        driver.getBookings().add(savedBooking);

        Customer savedCustomer = customerRepository.save(customer);
        Driver savedDriver = driverRepository.save(driver);

        sendEmail(savedCustomer);

        return BookingTransformer.bookingToBookingResponse(savedBooking,savedCustomer,availableCab,savedDriver);

    }


      private void sendEmail(Customer customer){

          String text = "Congrats!! " +customer.getName()+" "+ "Your cab for Satna to Pune has been booked successfully !!" ;


        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("instaride978@gmail.com");
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setSubject("Cab Booked");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);

    }
}
