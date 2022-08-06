package com.example.invoicetracker;

public class AnnualInvoice {
    private String invoiceID,lots,pieces,totalMade;

    public AnnualInvoice(String invoiceID,String lots,String pieces,String totalMade){
        this.invoiceID = invoiceID;
        this.lots = lots;
        this.pieces = pieces;
        this.totalMade = totalMade;
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
}
