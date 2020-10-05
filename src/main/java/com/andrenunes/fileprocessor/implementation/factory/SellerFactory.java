package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.domain.BaseEntity;
import com.andrenunes.fileprocessor.domain.Seller;

import java.math.BigDecimal;

public class SellerFactory implements BaseEntityFactory {

    private static final String DELIMITER = "ç";

    @Override
    public BaseEntity build(String record) {
        String[] splittedRecord = record.split(DELIMITER);

        return new Seller(
                splittedRecord[1],
                splittedRecord[2],
                new BigDecimal(splittedRecord[3])
        );
    }
}
