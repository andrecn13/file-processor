package com.andrenunes.fileprocessor.stubs;

import com.andrenunes.fileprocessor.model.Seller;

import java.math.BigDecimal;

public class SellerStub {

    public static Seller getSellerStub() {
        Seller seller = new Seller();
        seller.setCpf("1234567891234");
        seller.setName("Pedro");
        seller.setSalary(new BigDecimal("50000"));

        return seller;
    }
}
