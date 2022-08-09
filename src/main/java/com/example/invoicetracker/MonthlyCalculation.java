package com.example.invoicetracker;

public class MonthlyCalculation {
    private int numberOfLots,numberOfInvoices,numberOfPieces;
    private double shippingTotal,monthlyProfit;
    private String name;

    public MonthlyCalculation(int numberOfLots, int numberOfInvoices, int numberOfPieces, double shippingTotal, double monthlyProfit, String name) {
        this.numberOfLots = numberOfLots;
        this.numberOfInvoices = numberOfInvoices;
        this.numberOfPieces = numberOfPieces;
        this.shippingTotal = shippingTotal;
        this.monthlyProfit = monthlyProfit;
        this.name = name;
    }

    public int getNumberOfLots() {
        return numberOfLots;
    }

    public void setNumberOfLots(int numberOfLots) {
        this.numberOfLots = numberOfLots;
    }

    public int getNumberOfInvoices() {
        return numberOfInvoices;
    }

    public void setNumberOfInvoices(int numberOfInvoices) {
        this.numberOfInvoices = numberOfInvoices;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    public double getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(double shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public double getMonthlyProfit() {
        return monthlyProfit;
    }

    public void setMonthlyProfit(double monthlyProfit) {
        this.monthlyProfit = monthlyProfit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
