package com.andrenunes.fileprocessor.stubs;

import com.andrenunes.fileprocessor.model.Model;
import com.andrenunes.fileprocessor.model.Sale;

import java.util.Arrays;
import java.util.List;

public class SaleStub {

    public static List<Model> getSalesStub() {
         return Arrays.asList(getSaleForPedroStub(), getSaleForJoaoStub());
    }

    public static Sale getSaleForPedroStub() {
        Sale sale = new Sale();
        sale.setId(1L);
        sale.setItems(ItemStub.getItemsListGoodSellerStub());
        sale.setSellerName("Pedro");

        return sale;
    }

    public static Sale getSaleForJoaoStub() {
        Sale sale = new Sale();
        sale.setId(2L);
        sale.setItems(ItemStub.getItemsListWorstSellerStub());
        sale.setSellerName("Joao");

        return sale;
    }
}
