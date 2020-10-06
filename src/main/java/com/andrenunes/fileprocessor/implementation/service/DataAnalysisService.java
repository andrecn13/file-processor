package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.model.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataAnalysisService {

    /**
     * Get quantity of Customers in list
     * @param models list of {@link Model}
     * @return quantity
     */
    public Long getCustomersQuantity(List<Model> models) {
        return models.stream()
                .filter(entity -> entity instanceof Customer)
                .map(entity -> (Customer) entity)
                .count();
    }

    /**
     * Get quantity of sellers in list
     * @param models list of {@link Model}
     * @return quantity
     */
    public Long getSellersQuantity(List<Model> models) {
        return models.stream()
                .filter(entity -> entity instanceof Seller)
                .map(entity -> (Seller) entity)
                .count();
    }

    /**
     * Get a list of {@link Sale}
     *
     * @param models list of {@link Model}
     * @return list of {@link Sale}
     */
    public List<Sale> getSales(List<Model> models) {
        return models.stream()
                .filter(entity -> entity instanceof Sale)
                .map(entity -> (Sale) entity)
                .collect(Collectors.toList());
    }

    /**
     * Get the most expensive sale id
     *
     * @param models list of {@link Model}
     * @return an {@link Sale} object
     */
    public Sale getMostExpensiveSale(List<Model> models) {
        List<Sale> sales = getSales(models);

        return Collections
                .max(sales, Comparator.comparing(this::totalPrice));
    }

    /**
     * Get the name of worst seller
     *
     * @param models list of {@link Model}
     * @return the name o the seller
     */
    public String getWorstSeller(List<Model> models) {
        List<Sale> sales = getSales(models);

        Map<String, BigDecimal> mapTotalsBySeller = sales.stream()
                .collect(Collectors.toMap(Sale::getSellerName, this::totalPrice, BigDecimal::add));

        return Collections
                .min(mapTotalsBySeller.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private BigDecimal totalPrice(Sale sale) {
        return getSumItems(sale.getItems());
    }

    /**
     * Sum price of all items
     *
     * @param items list of items {@link Item}
     * @return total price
     */
    private BigDecimal getSumItems(List<Item> items) {
        return items
                .stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
