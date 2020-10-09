package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.implementation.service.interfaces.ReportDigester;
import com.andrenunes.fileprocessor.model.Model;
import com.andrenunes.fileprocessor.model.ReportAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ReportService implements ReportDigester {
    Logger logger = LoggerFactory.getLogger(ReportService.class);

    private DataAnalysisService dataAnalysisService;

    public ReportService(DataAnalysisService dataAnalysisService) {
        this.dataAnalysisService = dataAnalysisService;
    }

    @Override
    public void generateReport(List<Model> entities, Path outputFile) throws FileNotFoundException {
        if(Objects.isNull(outputFile)) throw new FileNotFoundException();

        ReportAnalysis reportResponse = new ReportAnalysis();
        reportResponse.setTotalOfCustomers(dataAnalysisService.getCustomersQuantity(entities));
        reportResponse.setTotalOfSellers(dataAnalysisService.getSellersQuantity(entities));
        reportResponse.setMostExpensiveSaleId(dataAnalysisService.getMostExpensiveSale(entities).getId());
        reportResponse.setWorstSeller(dataAnalysisService.getWorstSeller(entities));

        try(PrintWriter writer = new PrintWriter(outputFile.toFile())) {
            writer.println(String.format("Quantidade de clientes no arquivo de entrada: %d", reportResponse.getTotalOfCustomers()));
            writer.println(String.format("Quantidade de vendedor no arquivo de entrada: %d", reportResponse.getTotalOfSellers()));
            writer.println(String.format("ID da venda mais cara: %d", reportResponse.getMostExpensiveSaleId()));
            writer.println(String.format("O pior vendedor: %s", reportResponse.getWorstSeller()));

        } catch (FileNotFoundException e) {
            logger.error("Report file not found: {}", outputFile.toString());
        }

    }




}
