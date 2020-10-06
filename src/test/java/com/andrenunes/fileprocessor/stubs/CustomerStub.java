package com.andrenunes.fileprocessor.stubs;

import com.andrenunes.fileprocessor.model.Customer;

public class CustomerStub {

    public static Customer getCustomerStub() {
        Customer customer = new Customer();
        customer.setBusinessArea("Rural");
        customer.setCnpj("2345675434544345");
        customer.setName("Jose da Silva");

        return customer;
    }
}
