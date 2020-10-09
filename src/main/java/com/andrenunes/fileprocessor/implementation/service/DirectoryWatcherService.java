package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.config.EnvironmentProperties;
import com.andrenunes.fileprocessor.implementation.service.interfaces.FileDigester;
import com.andrenunes.fileprocessor.implementation.service.interfaces.ReportDigester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.nio.file.*;

public class DirectoryWatcherService {
    Logger logger = LoggerFactory.getLogger(DirectoryWatcherService.class);

    private WatchService watchService;
    private EnvironmentProperties environmentProperties;
    private FileDigester fileDigester;
    private ReportDigester reportDigester;

    public DirectoryWatcherService(WatchService watchService, EnvironmentProperties environmentProperties, FileDigester fileDigester, ReportDigester reportDigester) {
        this.watchService = watchService;
        this.environmentProperties = environmentProperties;
        this.fileDigester = fileDigester;
        this.reportDigester = reportDigester;
    }

    public void startProcessingFiles() {
        try {

            WatchKey key;
            while ((key = watchService.take()) != null) {

                key.pollEvents().forEach(watchEvent -> {
                    Path inputFile = getInputFile(watchEvent);
                    Path outputFile = getOutputFile(inputFile, Paths.get(environmentProperties.getDirectoryOut()));

                    logger.info("File detected: {}", inputFile.toString());

                    if (inputFile.toString().endsWith(environmentProperties.getExtensionIn())) {
                        try {
                            reportDigester.generateReport(
                                    fileDigester.parseFile(inputFile),
                                    outputFile);
                        } catch (FileNotFoundException e) {
                            logger.info("File not found: {}", e.getMessage());
                        }

                        logger.info("File successfully processed");
                    }

                });

                key.reset();
            }
        } catch (InterruptedException e) {
            logger.error("Watch service stopped: " + e.getMessage());
        }
    }

    private Path getInputFile(WatchEvent<?> event) {
        return Paths.get(environmentProperties.getDirectoryIn())
                .resolve((Path) event.context());
    }

    private Path getOutputFile(Path inputFile, Path outputPath) {
        String fileName = inputFile.getFileName().toString();

        return outputPath
                .resolve(fileName.replace(environmentProperties.getExtensionIn(), environmentProperties.getExtensionOut()));
    }


}
