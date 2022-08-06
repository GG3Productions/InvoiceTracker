package com.example.invoicetracker;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;

public class AnnualProfitsController {
    FileInputStream invoiceFilePath = new FileInputStream("C:\\Users\\MGU31\\Invoice file .xlsx");
    @FXML
    private Button refresh;

    @FXML
    private TableView annualTable;

    @FXML
    private Label yearsProfit,yearsPieces,yearsLots;



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

        DataFormatter formatter = new DataFormatter();
        FormulaEvaluator evaluator = invoiceWorkbook.getCreationHelper().createFormulaEvaluator();
        DecimalFormat df = new DecimalFormat("#.##");


        int counter = 0;
        int totalLots = 0;
        int totalPieces = 0;
        double entireTotalMade = 0.00;

        Iterator<Row> rowIterator = invoiceSheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            if (row.getCell(3 )!= null && row.getCell(3).getCellType() != CellType.BLANK) {
                String invoiceID = formatter.formatCellValue(row.getCell(3));
                String totalMade = formatter.formatCellValue(row.getCell(9), evaluator);
                String lots = formatter.formatCellValue(row.getCell(2));
                String pieces = formatter.formatCellValue(row.getCell(1));

                int tempLots = Integer.parseInt(lots);
                totalLots = totalLots + tempLots;

                int tempPieces = Integer.parseInt(pieces);
                totalPieces = totalPieces + tempPieces;

                double tempTotalMade = row.getCell(9).getNumericCellValue();
                entireTotalMade = entireTotalMade + tempTotalMade;

                AnnualInvoice invoice = new AnnualInvoice(invoiceID,lots,pieces,totalMade);
                annualTable.getItems().add(invoice);
            }
        }
        yearsLots.setText(String.valueOf(totalLots));
        yearsPieces.setText(String.valueOf(totalPieces));
        yearsProfit.setText("$" + String.valueOf(df.format(entireTotalMade)));
    }
}
