package com.andrenunes.fileprocessor.implementation.parser;

import com.andrenunes.fileprocessor.domain.BaseEntity;
import com.andrenunes.fileprocessor.implementation.binder.EntityTypeBinder;
import com.andrenunes.fileprocessor.core.BaseEntityFactory;
import com.andrenunes.fileprocessor.implementation.factory.enums.EntityType;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileParser {

    public FileParser() {}

    public List<BaseEntity> parseLines(List<String> lines) {
        return lines.stream()
                .map(mapToEntity())
                .collect(Collectors.toList());
    }

    private Function<String, BaseEntity> mapToEntity() {
        return line -> {
            EntityType entityType = getFactoryFromText(line);
            BaseEntityFactory factory = entityType.getFactory();

            return factory.build(line);
        };
    }

    private EntityType getFactoryFromText(String line) {
        return EntityTypeBinder.bindFromLine(line);
    }


}
