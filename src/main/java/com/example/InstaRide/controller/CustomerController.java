package com.example.InstaRide.controller;

import com.example.InstaRide.Enum.Gender;
import com.example.InstaRide.dto.request.CustomerRequest;
import com.example.InstaRide.dto.response.CustomerResponse;
import com.example.InstaRide.model.Customer;
import com.example.InstaRide.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest)
    {
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer (@PathVariable("id") int customerId)
    {
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getAllByGender(@PathVariable("gender") Gender gender)
    {
        return customerService.getAllByGender(gender);
    }

    
    // get all the people of particular gender and age ex - all males of age 25
    
    @GetMapping("/get")
    public List<CustomerResponse> getAllByGenderAndAge(@RequestParam ("gender")Gender gender,
                                                       @RequestParam("age") int age){
        return customerService.getAllByGenderAndAge(gender,age);
    }

    //get all the people of a particular gender and whose age > input

    @GetMapping("/get-by-age-greater-than")
    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(@RequestParam ("gender") String gender,
                                                       @RequestParam("age") int age){
        return customerService.getAllByGenderAndAgeGreaterThan(gender,age);
    }



}
