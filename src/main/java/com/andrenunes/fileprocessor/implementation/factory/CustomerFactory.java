package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.implementation.exception.InvalidLineFoundException;
import com.andrenunes.fileprocessor.model.Model;
import com.andrenunes.fileprocessor.model.Customer;

import java.util.Objects;

public class CustomerFactory implements BaseEntityFactory {
    private static final String DELIMITER = "ç";

    @Override
    public Model build(String record) {
        if(Objects.isNull(record) || record.length() < 3) throw new InvalidLineFoundException();
        String[] splittedRecord = record.split(DELIMITER);

        return new Customer(
                splittedRecord[1],
                splittedRecord[2],
                splittedRecord[3]
        );
    }
}
