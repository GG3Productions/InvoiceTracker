package com.example.invoicetracker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;

public class AnnualProfitsController {

    @FXML
    private Button refresh;

    @FXML
    private Button done;

    @FXML
    private TableColumn<Invoice, Integer > invoiceID;

    @FXML
    private TableColumn<Invoice, Double>totalMade;

    @FXML
    private TableColumn<Invoice, Integer>lots;

    @FXML
    private TableColumn<Invoice, Integer>pieces;

    @FXML
    void onRefreshClick(){

    }

    @FXML
    void onDoneClick(){

    }

}
