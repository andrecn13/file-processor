package com.andrenunes.fileprocessor.implementation.factory.enums;

import com.andrenunes.fileprocessor.implementation.factory.BaseEntityFactory;
import com.andrenunes.fileprocessor.implementation.factory.CustomerFactory;
import com.andrenunes.fileprocessor.implementation.factory.SaleFactory;
import com.andrenunes.fileprocessor.implementation.factory.SellerFactory;

import java.util.Arrays;
import java.util.Optional;

public enum EntityType {
    CUSTOMER("002") {
        @Override
        public BaseEntityFactory getFactory() {
            return new CustomerFactory();
        }
    },
    SELLER("001") {
        @Override
        public BaseEntityFactory getFactory() {
            return new SellerFactory();
        }
    },
    SALE("003") {
        @Override
        public BaseEntityFactory getFactory() {
            return new SaleFactory();
        }
    };

    private String pattern;

    EntityType(String pattern) {
        this.pattern = pattern;
    }

    public abstract BaseEntityFactory getFactory();

    public String getPattern() {
        return pattern;
    }

    public static Optional<EntityType> fromText(String text) {
        return Arrays.stream(values())
                .filter(value -> value.pattern.equalsIgnoreCase(text))
                .findFirst();
    }
}
