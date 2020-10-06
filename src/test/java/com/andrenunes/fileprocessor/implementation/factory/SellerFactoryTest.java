package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.model.Seller;
import com.andrenunes.fileprocessor.stubs.SellerStub;
import org.junit.Test;

import static org.junit.Assert.*;

public class SellerFactoryTest {

    private SellerFactory sellerFactory;

    public SellerFactoryTest() {
        this.sellerFactory = new SellerFactory();
    }

    @Test
    public void testBuildValidSeller() {
        Seller seller = (Seller) sellerFactory.build("001ç1234567891234çPedroç50000");
        Seller sellerExpected = SellerStub.getSellerStub();

        assertNotNull(seller);
        assertEquals(sellerExpected.getCpf(), seller.getCpf());
        assertEquals(sellerExpected.getName(), seller.getName());
        assertEquals(sellerExpected.getSalary(), seller.getSalary());
    }
}
