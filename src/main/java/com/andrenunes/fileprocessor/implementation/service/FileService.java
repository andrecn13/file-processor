package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.domain.BaseEntity;
import com.andrenunes.fileprocessor.domain.ReportResponse;
import com.andrenunes.fileprocessor.implementation.parser.FileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileService implements FileDigester {
    Logger logger = LoggerFactory.getLogger(FileService.class);

    @Override
    public List<BaseEntity> parseFile(Path inputFile) {
        logger.info("Parsing file: {}", inputFile.toString());

        try {
            FileParser fileParser = new FileParser();

            return fileParser
                    .parseLines(Files.readAllLines(inputFile));

        } catch (IOException e) {
            logger.error("Error trying to read lines from file: {}", inputFile.toString());
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

}
