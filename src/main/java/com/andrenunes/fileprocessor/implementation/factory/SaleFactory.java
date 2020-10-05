package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.model.Model;
import com.andrenunes.fileprocessor.model.Item;
import com.andrenunes.fileprocessor.model.Sale;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SaleFactory implements BaseEntityFactory {

    private static final String DELIMITER = "ç";

    @Override
    public Model build(String record) {
        String[] splittedRecord = record.split(DELIMITER);

        return new Sale(
                Long.parseLong(splittedRecord[1]),
                parseItems(splittedRecord[2]),
                splittedRecord[3]

        );
    }

    private List<Item> parseItems(String itemsRecord) {
        List<String> items = Arrays.asList(itemsRecord
                .replace("[", "")
                .replace("]", "")
                .split(","));

        BaseEntityFactory factory = new ItemFactory();

        return  items.stream()
                .map(item -> (Item)factory.build(item))
                .collect(Collectors.toList());

    }
}
