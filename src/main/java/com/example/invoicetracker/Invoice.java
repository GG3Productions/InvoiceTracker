package com.example.invoicetracker;

import java.time.LocalDate;
import java.util.Date;

public class Invoice {
    LocalDate date;
    private int lots,piece, invoiceNumber, orderNumber;
    private double orderTotal, finalTotal,shipping,refunds,totalMade;

    public Invoice(LocalDate date, int lots, int piece, int invoiceNum, int orderNumber,
                   double orderTotal, double finalTotal, double refund, double shipping,
                   double totalMade) {
        this.date = date;
        this.lots = lots;
        this.piece = piece;
        this.invoiceNumber = invoiceNum;
        this.orderNumber = orderNumber;
        this.orderTotal = orderTotal;
        this.finalTotal = finalTotal;
        this.refunds = refund;
        this.shipping = shipping;
        this.totalMade = totalMade;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getLots() {
        return lots;
    }

    public int getPiece() {
        return piece;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public double getFinalTotal() {
        return finalTotal;
    }

    public double getShipping() {
        return shipping;
    }

    public double getRefunds() {
        return refunds;
    }

    public double getTotalMade() {
        return totalMade;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setLots(int lots) {
        this.lots = lots;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }

    public void setRefunds(double refunds) {
        this.refunds = refunds;
    }

    public void setTotalMade(double totalMade) {
        this.totalMade = totalMade;
    }
}
