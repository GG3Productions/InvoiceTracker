package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;


public class MainMenuController {
    //open the new order invoice page and allow them to add new invoices.
    @FXML
    private Button newInvoice,newPurchase, viewMonthlyProfits,viewAnnualProfits;

    // allow for editing of the purchase tracker if information was mis entered
    @FXML
    private MenuItem editPurchaseTracker,editOrders,defaultFilePath;

    // When the new invoice button is clicked it brings the user to a new page that allows them to enter the new information on the invoice
    @FXML
    void onNewInvoiceClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddNewInvo.fxml")));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Adding New Invoice.....");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // When new purchase is clicked it sends the user to the new purchase page
    // So the user can now enter the information for a new purchase
    @FXML
    void onNewPurchaseClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewPurchase.fxml")));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setOnCloseRequest(evt ->{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "do you really want to cancel adding a new purchase?", ButtonType.YES,ButtonType.NO);
            ButtonType result = alert.showAndWait().orElse(ButtonType.NO);
            if(ButtonType.NO.equals(result)){
                evt.consume();
            }
        });
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("New Purchase.....");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // When the view monthly profits is clicked it gives a chart of cost/profit/sales for the current month that you are in.
    @FXML
    void onViewMonthlyProfitsClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MonthlyProfits.fxml")));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Monthly Profits");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // When the view annual profits is click it gives a chart of cost/ profit and sales for all year.
    @FXML
    void onViewAnnualProfit(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AnnualProfits.fxml")));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("Annual Profits");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // When edit orders is clicked it brings you to a window that allows you to edit the orders.
    @FXML
    void onEditOrdersClick(ActionEvent event)throws IOException {
        /**Parent root = FXMLLoader.load(getClass().getResource("NewPurchase.fxml"));
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("New Purchase.....");
        primaryStage.setScene(scene);
        primaryStage.show();**/
        //FIXME: set up the window to edit the information on orders
    }

    // when the edit purchases is clicked it brings the user to a new window that allows them to edit  previously entered purchases
    @FXML
    void onEditPurchaseTrackerClick(ActionEvent event)throws IOException {
        /**Parent root = FXMLLoader.load(getClass().getResource("NewPurchase.fxml"));
         Scene scene = new Scene(root);
         Stage primaryStage = new Stage();
         primaryStage.setTitle("New Purchase.....");
         primaryStage.setScene(scene);
         primaryStage.show();**/
        //FIXME: set up the window to edit the information on purchases
    }

    // this will bring you to a separate screen where you can set the individual file paths for accessing the Excel documents
    @FXML
    void setFilePathOnClick(){
        //TODO: create the method that makes these paths accessible to wherever they are needed
        //TODO: these file paths will allow for all sheets and pages to be accessed
    }
}