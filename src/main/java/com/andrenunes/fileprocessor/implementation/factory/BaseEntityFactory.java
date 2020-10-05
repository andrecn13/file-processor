package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.domain.BaseEntity;

public interface BaseEntityFactory {

    BaseEntity build(String record);
}
