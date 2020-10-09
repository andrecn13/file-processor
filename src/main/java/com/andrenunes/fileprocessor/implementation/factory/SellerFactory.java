package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.implementation.exception.InvalidLineFoundException;
import com.andrenunes.fileprocessor.model.Model;
import com.andrenunes.fileprocessor.model.Seller;

import java.math.BigDecimal;
import java.util.Objects;

public class SellerFactory implements BaseEntityFactory {

    private static final String DELIMITER = "ç";

    @Override
    public Model build(String record) {
        if(Objects.isNull(record) || record.length() < 3) throw  new InvalidLineFoundException();
        String[] splittedRecord = record.split(DELIMITER);

        return new Seller(
                splittedRecord[1],
                splittedRecord[2],
                new BigDecimal(splittedRecord[3])
        );
    }
}
