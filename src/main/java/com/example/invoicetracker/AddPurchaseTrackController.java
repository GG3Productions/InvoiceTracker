package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class AddPurchaseTrackController {
    @FXML
    private Button addTracker;
    @FXML
    private Button cancelTrackAdding;
    @FXML
    private Button editTrackAdds;
    @FXML
    private Button finishedAdding;
    @FXML
    private Label idBeingAddedTo;

    @FXML
    private TableColumn<PSets, Integer>index;

    @FXML
    private TableColumn<PSets, String>identity;

    @FXML
    private TableColumn<PSets, Double>profits;

    @FXML
    private TextField amountMade;

    @FXML
    void onFinishedClick(ActionEvent event) {
        //FIXME: add entry to the list of purchase tracking. Use the object ID number and create an object for an entry with each of the purchased tracking numbers.
    }
    @FXML
    void onEditClick(ActionEvent event){
        //FIXME: allow the user to edit any of the input data within the purchase tracking chart.
    }
    @FXML
    void onAddClick(ActionEvent event){
        //FIXME: Add to the list or purchase tracking located to the right view in the table.
    }
    @FXML
    void onCancelClick(ActionEvent event){
        //FIXME: Show  pop-up that asks "are you sure you want to cancel" send them back to the previous screen and make sure they uncheck the purchase tracking
    }

}
