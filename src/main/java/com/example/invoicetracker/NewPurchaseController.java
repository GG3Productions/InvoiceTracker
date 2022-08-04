package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class NewPurchaseController {
    @FXML
    private Button addNewPurchase,cancelNewPurchase,Refresh;

    @FXML
    private TextField newPurchaseCost,newPurchaseID;

    @FXML
    private TextArea newPurchaseDescription;

    @FXML
    private TableColumn<PSets, String>purID;

    @FXML
    private TableColumn<PSets, Double>purCost;

    @FXML
    private TableColumn<PSets, Double>purSold;

    @FXML
    private TableColumn<PSets, Double>purProfit;

    @FXML
    private TableView<PSets> purchaseListHistory;


    @FXML
    void onRefreshClick(ActionEvent event){
        //FIXME: When the button is clicked read the excel document and out put into the table on the screen.
    }
    @FXML
    void onCancelClick(ActionEvent event){
    //FIXME: ask the user if they are sure they want to cancel adding a new purchase the return them to the main screen.
    }

    @FXML
    void onUpdateClick(ActionEvent event){
        //FIXME: add the new purchase to the excel document that holds all of the purchases.
    }
}
