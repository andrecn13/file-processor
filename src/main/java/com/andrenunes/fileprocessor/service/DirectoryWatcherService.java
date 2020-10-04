package com.andrenunes.fileprocessor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

@Component
public class DirectoryWatcherService {
    Logger logger = LoggerFactory.getLogger(DirectoryWatcherService.class);

    private WatchService watchService;

    @Autowired
    public DirectoryWatcherService(WatchService watchService) {
        this.watchService = watchService;
    }

    public void startProcessingFiles() {
        try {
            WatchKey key;
            while ((key = watchService.take()) != null) {

                for (WatchEvent<?> event : key.pollEvents()) {
                    logger.info("Processing file: {}", event.context());
                }

                key.reset();
            }
        } catch (InterruptedException e) {
            logger.error("Watch service stopped: " + e.getMessage());
        }
    }


}
