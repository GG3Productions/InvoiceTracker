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
import javafx.stage.WindowEvent;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;


public class NewPurchaseController {
    // TODO: Get filepath/File object
//    String filepath = "";
//    FileInputStream file = new FileInputStream(new File(filepath));
//    XSSFWorkbook workbook = new XSSFWorkbook(file);
//    XSSFSheet sheet = workbook.getSheetAt(1);

    @FXML
    private Button addNewPurchase;
    @FXML
    private Button Refresh;

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
    void onUpdateClick(ActionEvent event){
        //FIXME: add the new purchase to the excel document that holds all of the purchases.

    }
}
