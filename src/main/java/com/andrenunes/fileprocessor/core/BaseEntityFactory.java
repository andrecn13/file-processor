package com.andrenunes.fileprocessor.core;

import com.andrenunes.fileprocessor.domain.BaseEntity;

public interface BaseEntityFactory {

    BaseEntity build(String record);
}
