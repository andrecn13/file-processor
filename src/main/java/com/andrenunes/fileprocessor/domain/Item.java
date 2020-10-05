package com.andrenunes.fileprocessor.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 572320479432859365L;

    private Long id;
    private Long quantity;
    private BigDecimal price;

    public Item(Long id, Long quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }

    public Item() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
