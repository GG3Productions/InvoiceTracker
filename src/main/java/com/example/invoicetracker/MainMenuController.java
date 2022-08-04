package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuButton;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;
//i amn a mf marshin
//Yessir!!!!!!

public class MainMenuController {
    //open the new order invoice page and allow them to add new invoices.
    @FXML
    private Button newInvoice,newPurchase, viewMonthlyProfits,viewAnnualProfits;

    // allow for editing of the purchase tracker if information was mis entered
    @FXML
    private MenuItem editPurchaseTracker,editOrders;

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
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setTitle("New Purchase.....");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // When the view monthly profits is clicked it gives a chart of cost/profit/sales for the current month that you are in.
    @FXML
    void onViewMonthlyProfitsClick(ActionEvent event) {

    }

    // When the view annual profits is click it gives a chart of cost/ profit and sales for all year.
    @FXML
    void onViewAnnualProfit(ActionEvent event){

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
}