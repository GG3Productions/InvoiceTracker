package com.example.invoicetracker;

import java.util.Date;

public class AnnualInvoice {
    private String invoiceID;
    private String lots;
    private String pieces;
    private String totalMade;
    private String dateString;

    public AnnualInvoice(String invoiceID, String lots, String pieces, String totalMade, String dateString){
        this.invoiceID = invoiceID;
        this.lots = lots;
        this.pieces = pieces;
        this.totalMade = totalMade;
        this.dateString = dateString;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getLots() {
        return lots;
    }

    public void setLots(String lots) {
        this.lots = lots;
    }

    public String getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }

    public String getTotalMade() {
        return totalMade;
    }

    public void setTotalMade(String totalMade) {
        this.totalMade = totalMade;
    }

    public String getDate() {
        return dateString;
    }

    public void setDate(Date date) {
        this.dateString = dateString;
    }
}
