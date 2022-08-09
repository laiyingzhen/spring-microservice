package com.simple.fraud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FraudCheckResponse {
    private Boolean isFraudster;
    public Boolean isFraudulentCustomer(){
        return this.isFraudster;
    }
}

