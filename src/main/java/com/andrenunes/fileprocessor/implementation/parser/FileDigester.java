package com.andrenunes.fileprocessor.implementation.parser;

import com.andrenunes.fileprocessor.model.Model;

import java.nio.file.Path;
import java.util.List;

public interface FileDigester {

    List<Model> parseFile(Path inputFile);
}
