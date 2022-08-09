package com.simple.customer.controller;

import com.simple.customer.request.CustomerRegisterationRequest;
import com.simple.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerController {
    @Value("${profile}")
    private String profileData;
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegisterationRequest customerRequest){
        log.info("new customer registeration {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
    @GetMapping("/profile")
    public String getProfile(){
        return this.profileData;
        //return "test";
    }
}
