package com.example.InstaRide.service;

import com.example.InstaRide.Enum.Gender;
import com.example.InstaRide.dto.request.CustomerRequest;
import com.example.InstaRide.dto.response.CustomerResponse;
import com.example.InstaRide.exception.CustomerNotFoundException;
import com.example.InstaRide.model.Customer;
import com.example.InstaRide.repository.CustomerRepository;
import com.example.InstaRide.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        //RequestDTO -> Entity because repo knows only Entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

        // save entity to DB
        Customer savedCustomer = customerRepository.save(customer);

        //Saved Entity -> Response DTO
       return CustomerTransformer.customerToCustomerResponse(customer);

    }

    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid customer id");
        }


        Customer savedCustomer = optionalCustomer.get();
        //Saved Entity -> Response DTO
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }


    public List<CustomerResponse> getAllByGender(Gender gender) {
        List<Customer> customers = customerRepository.findByGender(gender);

        //entity --> response DTO
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer: customers)
        {
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers = customerRepository.findByGenderAndAge(gender, age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer: customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(String gender, int age) {

        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender, age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer: customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
