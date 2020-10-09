package com.andrenunes.fileprocessor.implementation.service;

import com.andrenunes.fileprocessor.model.Sale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class ReportServiceTest {

    @InjectMocks
    private ReportService reportService;

    @Mock
    private DataAnalysisService dataAnalysisService;


    @Test(expected = FileNotFoundException.class)
    public void test() throws FileNotFoundException {
        when(dataAnalysisService.getCustomersQuantity(any())).thenReturn(1L);
        when(dataAnalysisService.getMostExpensiveSale(any())).thenReturn(new Sale(1L, null, null));
        when(dataAnalysisService.getSellersQuantity(any())).thenReturn(1L);
        when(dataAnalysisService.getWorstSeller(any())).thenReturn("Joao");

        reportService.generateReport(null, null);
    }
}
