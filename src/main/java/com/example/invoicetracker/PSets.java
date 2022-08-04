package com.example.invoicetracker;

public class PSets {
    String purchaseID, description;
    double cost,profit,sold;

    public PSets(String pID, double pCost, String pDescription, double pProfit){
        this.sold = 0;
        this.purchaseID = pID;
        this.description = pDescription;
        this.cost = pCost;
        this.profit = pProfit;
    }
}
