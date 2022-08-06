package com.example.invoicetracker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class AnnualProfitsController {
    FileInputStream invoiceFilePath = new FileInputStream("C:\\Users\\MGU31\\OneDrive\\Desktop\\Invoice file .xlsx");
    @FXML
    private Button refresh;

    @FXML
    private Button done;

    @FXML
    private TableView annualTable;

    @FXML
    private TableColumn<AnnualInvoice, String> invoiceIDColumn;

    @FXML
    private TableColumn<AnnualInvoice, String>totalMadeColumn;

    @FXML
    private TableColumn<AnnualInvoice, String>lotsColumn;

    @FXML
    private TableColumn<AnnualInvoice, String>piecesColumn;

    public AnnualProfitsController() throws FileNotFoundException {
    }

    @FXML
    void onRefreshClick() throws IOException {
        XSSFWorkbook invoiceWorkbook = new XSSFWorkbook(invoiceFilePath);
        XSSFSheet invoiceSheet = invoiceWorkbook.getSheetAt(0);

        invoiceIDColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceID"));
        lotsColumn.setCellValueFactory(new PropertyValueFactory<>("lots"));
        totalMadeColumn.setCellValueFactory(new PropertyValueFactory<>("totalMade"));
        piecesColumn.setCellValueFactory(new PropertyValueFactory<>("pieces"));

        Iterator<Row> rowIterator = invoiceSheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            String invoiceID = String.valueOf(row.getCell(3));
            String totalMade = String.valueOf(row.getCell(9));
            String pieces = String.valueOf(row.getCell(1));
            String lots = String.valueOf(row.getCell(2));

            AnnualInvoice invoice = new AnnualInvoice(invoiceID,lots,pieces,totalMade);
            annualTable.getItems().add(invoice);
        }
    }

    @FXML
    void onDoneClick(){

    }

}
