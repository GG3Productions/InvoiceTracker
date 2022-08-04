package com.example.invoicetracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateStringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class NewWindowController implements Initializable {

    @FXML
    private TableView<Invoice> invoiceTable;

    @FXML
    private TableColumn<Invoice, LocalDate> inDate;

    @FXML
    private TableColumn<Invoice, Double> inFinalTtl;

    @FXML
    private TableColumn<Invoice, Integer> inLotQty;

    @FXML
    private TableColumn<Invoice, Integer> inNum;

    @FXML
    private TableColumn<Invoice, Integer> inOrderNum;

    @FXML
    private TableColumn<Invoice, Double> inOrderTtl;

    @FXML
    private TableColumn<Invoice, Integer> inPiece;

    @FXML
    private TableColumn<Invoice, Double> inRefund;

    @FXML
    private TableColumn<Invoice, Double> inShipping;

    @FXML
    private TableColumn<Invoice, Double> inTotalMade;




    ObservableList<Invoice> list = FXCollections.observableArrayList(
            new Invoice(LocalDate.now(),8,7,123456123,456,2.37,7.57,0,5.42,708.30),
            new Invoice(LocalDate.now(),8,8,123456123,456,2.37,7.57,0,5.42,708.30),
            new Invoice(LocalDate.now(),8,9,123456123,456,2.37,7.57,0,5.42,708.30)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inDate.setCellValueFactory(new PropertyValueFactory<Invoice,LocalDate>("date"));
        inLotQty.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("lots"));
        inPiece.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("piece"));
        inNum.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("invoiceNumber"));
        inOrderNum.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("orderNumber"));
        inOrderTtl.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("orderTotal"));
        inFinalTtl.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("finalTotal"));
        inRefund.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("refund"));
        inShipping.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("shipping"));
        inTotalMade.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("totalMade"));

        invoiceTable.setItems(list);
    }
}

