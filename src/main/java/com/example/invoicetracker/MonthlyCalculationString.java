package com.example.invoicetracker;

public class MonthlyCalculationString {
    String name,lots,invoice,numberOfPieces,shippingTotal,monthlyProfit;

    public MonthlyCalculationString(String name, String lots, String numberOfPieces, String shippingTotal, String monthlyProfit, String Invoice) {
        this.name = name;
        this.lots = lots;
        this.numberOfPieces = numberOfPieces;
        this.shippingTotal = shippingTotal;
        this.monthlyProfit = monthlyProfit;
        this.invoice = invoice;
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

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }
}
