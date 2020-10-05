package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.domain.BaseEntity;

import java.nio.file.Path;
import java.util.List;

public interface FileDigester {

    List<BaseEntity> parseFile(Path inputFile);
}
