package com.andrenunes.fileprocessor;

import com.andrenunes.fileprocessor.config.EnvironmentProperties;
import com.andrenunes.fileprocessor.implementation.service.DirectoryWatcherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements ApplicationRunner {
	Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private EnvironmentProperties environmentProperties;

	@Autowired
	private DirectoryWatcherService directoryWatcherService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Application started and watching files in: {}", environmentProperties.getDirectoryIn());
		directoryWatcherService.startProcessingFiles();
	}
}
