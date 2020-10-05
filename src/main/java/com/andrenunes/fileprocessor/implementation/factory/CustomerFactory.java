package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.domain.BaseEntity;
import com.andrenunes.fileprocessor.domain.Customer;

public class CustomerFactory implements BaseEntityFactory {
    private static final String DELIMITER = "ç";

    @Override
    public BaseEntity build(String record) {
        String[] splittedRecord = record.split(DELIMITER);

        return new Customer(
                splittedRecord[1],
                splittedRecord[2],
                splittedRecord[3]
        );
    }
}
