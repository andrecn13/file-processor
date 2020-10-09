package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.implementation.exception.InvalidLineFoundException;
import com.andrenunes.fileprocessor.model.Model;
import com.andrenunes.fileprocessor.model.Item;

import java.math.BigDecimal;
import java.util.Objects;

public class ItemFactory implements BaseEntityFactory {

    private static final String DELIMITER = "-";

    @Override
    public Model build(String record) {
        if(Objects.isNull(record) || record.length() < 3) throw new InvalidLineFoundException();

        String[] splittedRecord = record.split(DELIMITER);

        BigDecimal price = new BigDecimal(splittedRecord[2]);

        return new Item(
                new Long(splittedRecord[0]),
                new Long(splittedRecord[1]),
                price
        );
    }
}
