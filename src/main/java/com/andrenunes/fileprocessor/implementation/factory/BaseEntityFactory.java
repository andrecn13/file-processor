package com.andrenunes.fileprocessor.implementation.factory;

import com.andrenunes.fileprocessor.implementation.exception.InvalidLineFoundException;
import com.andrenunes.fileprocessor.model.Model;

public interface BaseEntityFactory {

    Model build(String record);
}
