package com.andrenunes.fileprocessor.implementation.binder;

import com.andrenunes.fileprocessor.implementation.factory.enums.EntityType;

import java.util.Objects;

public class EntityTypeBinder {

    public static EntityType bindFromLine(String line) {
        if (Objects.isNull(line) || line.trim().isEmpty()) throw new IllegalArgumentException("Line not recognized");

        String type = line.substring(0, 3);

        return EntityType
                .fromText(type)
                .orElseThrow(IllegalArgumentException::new);
    }
}
