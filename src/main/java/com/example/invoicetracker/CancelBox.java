package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CancelBox {
    @FXML
    public Button noButton, yesButton;

    public CancelBox() {

    }

    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) noButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage) noButton.getScene().getWindow();
        stage.close();
        // TODO: close NewPurchase window
    }
}
