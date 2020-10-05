package com.andrenunes.fileprocessor.model;

import java.io.Serializable;

public class ReportAnalysis implements Serializable {

    private static final long serialVersionUID = 4333459863634169399L;

    private int totalOfCustomers;
    private int totalOfSellers;
    private long mostExpensiveSaleId;
    private String worstSeller;

    public ReportAnalysis() {
    }

    public ReportAnalysis(int totalOfCustomers, int totalOfSellers, long mostExpensiveSaleId, String worstSeller) {
        this.totalOfCustomers = totalOfCustomers;
        this.totalOfSellers = totalOfSellers;
        this.mostExpensiveSaleId = mostExpensiveSaleId;
        this.worstSeller = worstSeller;
    }

    public int getTotalOfCustomers() {
        return totalOfCustomers;
    }

    public void setTotalOfCustomers(int totalOfCustomers) {
        this.totalOfCustomers = totalOfCustomers;
    }

    public int getTotalOfSellers() {
        return totalOfSellers;
    }

    public void setTotalOfSellers(int totalOfSellers) {
        this.totalOfSellers = totalOfSellers;
    }

    public long getMostExpensiveSaleId() {
        return mostExpensiveSaleId;
    }

    public void setMostExpensiveSaleId(long mostExpensiveSaleId) {
        this.mostExpensiveSaleId = mostExpensiveSaleId;
    }

    public String getWorstSeller() {
        return worstSeller;
    }

    public void setWorstSeller(String worstSeller) {
        this.worstSeller = worstSeller;
    }
}
