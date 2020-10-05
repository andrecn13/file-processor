package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.core.BaseEntityFactory;
import com.andrenunes.fileprocessor.domain.BaseEntity;
import com.andrenunes.fileprocessor.domain.Item;

import java.math.BigDecimal;

public class ItemFactory implements BaseEntityFactory {

    private static final String DELIMITER = "-";

    @Override
    public BaseEntity build(String record) {
        String[] splittedRecord = record.split(DELIMITER);

        BigDecimal price = new BigDecimal(splittedRecord[2]);

        return new Item(
                new Long(splittedRecord[0]),
                new Long(splittedRecord[1]),
                price
        );
    }
}
