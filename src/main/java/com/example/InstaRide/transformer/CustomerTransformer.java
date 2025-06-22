package com.example.InstaRide.transformer;

import com.example.InstaRide.dto.request.CustomerRequest;
import com.example.InstaRide.dto.response.CustomerResponse;
import com.example.InstaRide.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest) {
      //  Customer customer = new Customer();
     //   customer.setName(customerRequest.getName());
       // customer.setAge(customerRequest.getAge());
       // customer.setEmailId(customerRequest.getEmailId());
       // customer.setGender(customerRequest.getGender());
       // return customer;

        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .gender(customerRequest.getGender())
                .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer) {
      return CustomerResponse.builder()
              .name(customer.getName())
              .emailId(customer.getEmailId())
              .age(customer.getAge())
              .build();
    }
}