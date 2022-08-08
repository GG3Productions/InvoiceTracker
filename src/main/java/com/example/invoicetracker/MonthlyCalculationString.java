package com.example.invoicetracker;

public class MonthlyCalculationString {
    String name,lots,invoices,numberOfPieces,shippingTotal,monthlyProfit;

    public MonthlyCalculationString(String name, String lots, String invoices, String numberOfPieces, String shippingTotal, String monthlyProfit) {
        this.name = name;
        this.lots = lots;
        this.invoices = invoices;
        this.numberOfPieces = numberOfPieces;
        this.shippingTotal = shippingTotal;
        this.monthlyProfit = monthlyProfit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLots() {
        return lots;
    }

    public void setLots(String lots) {
        this.lots = lots;
    }

    public String getInvoices() {
        return invoices;
    }

    public void setInvoices(String invoices) {
        this.invoices = invoices;
    }

    public String getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(String numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public String getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(String shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public String getMonthlyProfit() {
        return monthlyProfit;
    }

    public void setMonthlyProfit(String monthlyProfit) {
        this.monthlyProfit = monthlyProfit;
    }
}
