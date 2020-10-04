package com.andrenunes.fileprocessor.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.*;

@Configuration
public class WatchServiceConfig {
    Logger logger = LoggerFactory.getLogger(WatchServiceConfig.class);

    @Bean
    public WatchService watchService(DirectoryProperties directoryProperties) {
        WatchService watchService = null;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(directoryProperties.getIn());

            if (!Files.isDirectory(path))
                throw new RuntimeException("Folder not found or is not a directory: " + path);


            path.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_CREATE
            );

        } catch (IOException e) {
            logger.error("Could not create watch service: ", e);
        }

        return watchService;
    }
}
