package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReportService implements ReportDigester {
    Logger logger = LoggerFactory.getLogger(ReportService.class);

    @Override
    public void generateReport(List<BaseEntity> entities, Path outputFile) {
        ReportResponse reportResponse = new ReportResponse();
        reportResponse.setTotalOfCustomers(getCustomers(entities).size());
        reportResponse.setTotalOfSellers(getSellers(entities).size());
        reportResponse.setMostExpensiveSaleId(getMostExpensiveSale(entities).getId());

        try(PrintWriter writer = new PrintWriter(outputFile.toFile())) {
            writer.println(String.format("Quantidade de clientes no arquivo de entrada: %d", reportResponse.getTotalOfCustomers()));
            writer.println(String.format("Quantidade de vendedor no arquivo de entrada: %d", reportResponse.getTotalOfSellers()));
            writer.println(String.format("ID da venda mais cara: %d", reportResponse.getMostExpensiveSaleId()));

        } catch (FileNotFoundException e) {
            logger.error("Report file not found: {}", outputFile.toString());
        }

    }

    private List<Customer> getCustomers(List<BaseEntity> entities) {
        return entities.stream()
                .filter(entity -> entity instanceof Customer)
                .map(entity -> (Customer) entity)
                .collect(Collectors.toList());
    }

    private List<Seller> getSellers(List<BaseEntity> entities) {
        return entities.stream()
                .filter(entity -> entity instanceof Seller)
                .map(entity -> (Seller) entity)
                .collect(Collectors.toList());
    }

    private List<Sale> getSales(List<BaseEntity> entities) {
        return entities.stream()
                .filter(entity -> entity instanceof Sale)
                .map(entity -> (Sale) entity)
                .collect(Collectors.toList());
    }

    public Sale getMostExpensiveSale(List<BaseEntity> entities) {
        List<Sale> sales = getSales(entities);

        return Collections
                .max(sales, Comparator.comparing(this::totalPrice));
    }

    private BigDecimal totalPrice(Sale sale) {
        return sale
                .getItems()
                .stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}