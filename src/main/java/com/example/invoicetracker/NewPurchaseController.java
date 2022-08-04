package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


public class NewPurchaseController {
    // TODO: Get filepath/File object
//    String filepath = "";
//    FileInputStream file = new FileInputStream(new File(filepath));
//    XSSFWorkbook workbook = new XSSFWorkbook(file);
//    XSSFSheet sheet = workbook.getSheetAt(1);

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

    public NewPurchaseController() throws IOException {
    }

    @FXML
    void onRefreshClick(ActionEvent event){
        //TODO: When the button is clicked read the excel document and out put into the table on the screen.
//        Iterator<Row> rowIterator = sheet.iterator();
//        while (rowIterator.hasNext()){
//            Row row = rowIterator.next();
//            // For each row, find the desired cells and write them to the GUI's table.
//        }
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
