package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;

public class AddNewInvoController {

    @FXML
    private Button cancelInvo, submitInvo;

    // when this button is clicked it means that there are items that have to be added to the tracking purchase sheet.
    @FXML
    private RadioButton purchaseTracking;

    @FXML
    private TextField tDay;

    @FXML
    private TextField tFinalTotal;

    @FXML
    private TextField tInvoiceNumber;

    @FXML
    private TextField tLots;

    @FXML
    private TextField tMonth;

    @FXML
    private TextField tOrderNumber;

    @FXML
    private TextField tOrderTotal;

    @FXML
    private TextField tPieces;

    @FXML
    private TextField tRefund;

    @FXML
    private TextField tShippingTotal;

    @FXML
    private TextField tYear;

    FileInputStream invoiceFilePath = new FileInputStream(new File("src/main/java/com/example/invoicetracker/dummyfile.xlsx"));

    public AddNewInvoController() throws FileNotFoundException {
    }

    @FXML
    void onSubmitClick(ActionEvent event) throws IOException {
        //TODO: make this add new invoice to the excel document

        // open the file and open the sheet
        XSSFWorkbook invoiceWorkbook = new XSSFWorkbook(invoiceFilePath);
        XSSFSheet invoiceSheet = invoiceWorkbook.getSheetAt(0);

        //Creating the formats of the decimals that we want
        DecimalFormat monyfmt = new DecimalFormat("$#.##");

        //This will get the text from the input spaces and convert them to their type to be used
        int lots = Integer.parseInt(tLots.getText());
        int pieces = Integer.parseInt(tPieces.getText());
        int orderNumber = Integer.parseInt(tOrderNumber.getText());
        int invoiceNumber = Integer.parseInt(tInvoiceNumber.getText());
        int day = Integer.parseInt(tDay.getText());
        int month = Integer.parseInt(tMonth.getText());
        int year = Integer.parseInt(tYear.getText());
        double finalTotal = Double.parseDouble(tFinalTotal.getText());
        double orderTotal = Double.parseDouble(tOrderTotal.getText());
        double refund = Double.parseDouble(tRefund.getText());
        double shipping = Double.parseDouble(tShippingTotal.getText());
        boolean invoiceExists = false;

        //Check to see if the invoice already exists if it exists stop the loop if not add the invoice.
        Iterator<Row> rowIterator = invoiceSheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext() && invoiceExists == false){
            Row entry = rowIterator.next();
            if(entry.getCell(3).getNumericCellValue() == invoiceNumber){
                invoiceExists = true;
            }
            if(entry.getCell(3).getNumericCellValue() != invoiceNumber){
                //TODO make it so that we find the next blank row and add the invoice

                //Gets the next empty row
                int rowCount = invoiceSheet.getLastRowNum();
                int newRow = rowCount + 1;

                //Updating a cell by calling the row then cell
                Cell pieceCell = invoiceSheet.getRow(newRow).getCell(1);
                pieceCell.setCellValue(pieces);
                Cell lotsCell = invoiceSheet.getRow(newRow).getCell(2);
                lotsCell.setCellValue(lots);
                Cell invoiceCell = invoiceSheet.getRow(newRow).getCell(3);
                invoiceCell.setCellValue(invoiceNumber);
                Cell orderNumberCell = invoiceSheet.getRow(newRow).getCell(4);
                orderNumberCell.setCellValue(orderNumber);
                Cell orderTotalCell = invoiceSheet.getRow(newRow).getCell(5);
                orderTotalCell.setCellValue(monyfmt.format(orderTotal));
                Cell finalTotalCell = invoiceSheet.getRow(newRow).getCell(6);
                finalTotalCell.setCellValue(monyfmt.format(finalTotal));


            }
        }
    }
    //TODO: Create a purchase tracker button that moves you to the purchase tracker page so that you can attach the purchase tracking to the invoice.


    @FXML
    void onCancelClick(ActionEvent event) {
        //FIXME: return to the main window and throw a pop-up that asks if the user truly wants to quite **/
    }

}