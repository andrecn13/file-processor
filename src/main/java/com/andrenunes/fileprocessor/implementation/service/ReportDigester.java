package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.domain.BaseEntity;

import java.nio.file.Path;
import java.util.List;

public interface ReportDigester {

    void generateReport(List<BaseEntity> entities, Path outputFile);
}
