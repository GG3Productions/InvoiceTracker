package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddNewInvoController {

    @FXML
    private Button cancelInvo, submitInvo;

    // when this button is clicked it means that there are items that have to be added to the tracking purchase sheet.
    @FXML
    private RadioButton purchaseTracking;

    // this is the month of the purchase date
    @FXML
    private TextField Month, day, year,lots,pieces,invoiceNumber,orderNumber,orderTotal,finalTotal,shippingTotal;


    @FXML
    void onSubmitClick(ActionEvent event) throws IOException {

        //FIXME: if the radiobutton is selected send the user to the add purchase tracking page
        if(purchaseTracking.isSelected()){
            Parent root = FXMLLoader.load(getClass().getResource("AddPurchaseTrack.fxml"));

            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Add Purchase Tracking Data");
            primaryStage.setScene(scene);
            primaryStage.show();
        }else {
            //FIXME: add the invoice to the excel document with that tracks the invoices no added purchased Tracking
        }
    }

    @FXML
    void onCancelClick(ActionEvent event) {
        //FIXME: return to the main window and throw a pop-up that asks if the user truly wants to quite **/
    }

}