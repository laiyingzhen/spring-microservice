package com.simple.customer.service;

import com.simple.customer.dao.CustomerRepository;
import com.simple.customer.model.Customer;
import com.simple.customer.model.FraudCheckResponse;
import com.simple.customer.request.CustomerRegisterationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegisterationRequest customerRegisterationRequest){
        Customer customer = Customer.builder().username("Emi wong").email("emiwong@gmail.com").build();
        // Use saveAndFlush to generate the customerId which can be used to connect to the fraud-check service
        customerRepository.saveAndFlush(customer);
        // todo : check if fraudster
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD:8081/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
        if(fraudCheckResponse.isFraudulentCustomer()){
            throw new IllegalStateException("CustomerId: "+customer.getId()+" is fraudster.");
        }
        // todo : send notification
    }
}
