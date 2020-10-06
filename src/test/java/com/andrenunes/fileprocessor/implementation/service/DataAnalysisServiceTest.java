package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.model.Model;
import com.andrenunes.fileprocessor.stubs.CustomerStub;
import com.andrenunes.fileprocessor.stubs.SaleStub;
import com.andrenunes.fileprocessor.stubs.SellerStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DataAnalysisServiceTest {

    private DataAnalysisService dataAnalysisService;

    public DataAnalysisServiceTest() {
        this.dataAnalysisService = new DataAnalysisService();
    }

    @Test
    public void testGetCustomersQuantity() {
        List<Model> customers = Arrays.asList(
                CustomerStub.getCustomerStub(),
                CustomerStub.getCustomerStub(),
                CustomerStub.getCustomerStub()
        );

        assertEquals(Long.valueOf(3), dataAnalysisService.getCustomersQuantity(customers));

    }

    @Test
    public void testGetSellerQuantity() {
        List<Model> sellers = Arrays.asList(
                SellerStub.getSellerStub(),
                SellerStub.getSellerStub(),
                SellerStub.getSellerStub(),
                SellerStub.getSellerStub()
        );

        assertEquals(Long.valueOf(4), dataAnalysisService.getSellersQuantity(sellers));
    }

    @Test
    public void testGetMostExpensiveSaleId() {
        List<Model> sales = SaleStub.getSalesStub();

        assertEquals(Long.valueOf(1), dataAnalysisService.getMostExpensiveSale(sales).getId());
    }

    @Test
    public void testGetWorstSellerName() {
        List<Model> sales = SaleStub.getSalesStub();

        assertEquals("Joao", dataAnalysisService.getWorstSeller(sales));
    }

}
