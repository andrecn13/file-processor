package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.model.Sale;
import com.andrenunes.fileprocessor.stubs.SaleStub;
import org.junit.Test;

import static org.junit.Assert.*;

public class SaleFactoryTest {

    private SaleFactory saleFactory;

    public SaleFactoryTest() {
        this.saleFactory = new SaleFactory();
    }

    @Test
    public void testBuildValidSale() {
        Sale sale = (Sale) saleFactory.build("003ç1ç[1-10-10,2-30-2.50]çPedro");
        Sale saleExpected = SaleStub.getSaleForPedroStub();

        assertNotNull(sale);
        assertEquals(saleExpected.getId(), sale.getId());
        assertEquals(saleExpected.getItems().size(), sale.getItems().size());
        assertEquals(saleExpected.getSellerName(), sale.getSellerName());
    }
}
