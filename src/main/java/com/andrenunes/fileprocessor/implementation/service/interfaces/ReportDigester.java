package com.andrenunes.fileprocessor.implementation.service.interfaces;

import com.andrenunes.fileprocessor.model.Model;

import java.nio.file.Path;
import java.util.List;

public interface ReportDigester {

    void generateReport(List<Model> entities, Path outputFile);
}
