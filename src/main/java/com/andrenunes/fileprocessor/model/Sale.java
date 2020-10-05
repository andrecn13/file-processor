package com.andrenunes.fileprocessor.model;

import java.io.Serializable;
import java.util.List;

public class Sale extends Model implements Serializable {

    private static final long serialVersionUID = 778411900286829901L;

    private Long id;
    private List<Item> items;
    private String sellerName;

    public Sale(Long id, List<Item> items, String sellerName) {
        this.id = id;
        this.items = items;
        this.sellerName = sellerName;
    }

    public Sale() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
