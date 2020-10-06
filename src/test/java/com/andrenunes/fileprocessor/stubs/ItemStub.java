package com.andrenunes.fileprocessor.stubs;

import com.andrenunes.fileprocessor.model.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemStub {

    public static List<Item> getItemsListGoodSellerStub() {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setPrice(new BigDecimal("10"));
        item1.setQuantity(10L);

        Item item2 = new Item();
        item2.setId(2L);
        item2.setPrice(new BigDecimal("2.50"));
        item2.setQuantity(30L);

        return Arrays.asList(item1,item2);
    }

    public static List<Item> getItemsListWorstSellerStub() {
        Item item1 = new Item();
        item1.setId(3L);
        item1.setPrice(new BigDecimal("1.3"));
        item1.setQuantity(2L);

        return Collections.singletonList(item1);
    }
}
