package com.andrenunes.fileprocessor.config;

import com.andrenunes.fileprocessor.implementation.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.*;

@Configuration
public class ServiceConfig {
    Logger logger = LoggerFactory.getLogger(ServiceConfig.class);

    @Bean
    public WatchService watchService(EnvironmentProperties environmentProperties) {
        WatchService watchService = null;
        try {
            watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get(environmentProperties.getDirectoryIn());

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

    @Bean
    public FileDigester fileDigester() {
        return new FileService();
    }

    @Bean
    public ReportDigester reportDigester() {
        return new ReportService();
    }

    @Bean
    public DirectoryWatcherService directoryWatcherService(
            WatchService watchService,
            EnvironmentProperties environmentProperties,
            FileDigester fileDigester,
            ReportDigester reportDigester
    ) {
        return new DirectoryWatcherService(
                watchService,
                environmentProperties,
                fileDigester,
                reportDigester
        );
    }
}
