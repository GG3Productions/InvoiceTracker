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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
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

    public AddNewInvoController() throws FileNotFoundException {
    }

    @FXML
    void onSubmitClick(ActionEvent event) throws IOException {
        //TODO: make this add new invoice to the excel document

        // open the file and open the sheet
        FileInputStream stream = new FileInputStream("src/main/java/com/example/invoicetracker/dummyfile.xlsx");
        XSSFWorkbook invoiceWorkbook = new XSSFWorkbook(stream);
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
        double totalMade = finalTotal - shipping;

        //Check to see if the invoice already exists if it exists stop the loop if not add the invoice.
        Iterator<Row> rowIterator = invoiceSheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext()){
            Row entry = rowIterator.next();
            if (entry.getCell(3).getCellType() == CellType.NUMERIC) {
                if(entry.getCell(3).getNumericCellValue() == invoiceNumber){
                    // TODO verification window of existing invoice
                    break;
                }
            }
        }
        //Gets the next empty row
        int rowCount = invoiceSheet.getLastRowNum(); // 174 here
        Row newRow = invoiceSheet.createRow(rowCount);


        //Updating a cell by calling the row then cell
        System.out.println("Writing to row " + rowCount);
        Cell pieceCell = newRow.createCell(1);
        pieceCell.setCellValue(pieces);
        Cell lotsCell = newRow.createCell(2);
        lotsCell.setCellValue(lots);
        Cell invoiceCell = newRow.createCell(3);
        invoiceCell.setCellValue(invoiceNumber);
        Cell orderNumberCell = newRow.createCell(4);
        orderNumberCell.setCellValue(orderNumber);
        Cell orderTotalCell = newRow.createCell(5);
        orderTotalCell.setCellValue(monyfmt.format(orderTotal));
        Cell finalTotalCell = newRow.createCell(6);
        finalTotalCell.setCellValue(monyfmt.format(finalTotal));
        Cell shippingCell = newRow.createCell(7);
        shippingCell.setCellValue(shipping);
        Cell refundCell = newRow.createCell(8);
        refundCell.setCellValue(refund);
        Cell totalMadeCell = newRow.createCell(9);
        totalMadeCell.setCellValue(totalMade);
        FileOutputStream out = new FileOutputStream("src/main/java/com/example/invoicetracker/dummyfile.xlsx");
        invoiceWorkbook.write(out);
        out.close();
        invoiceWorkbook.close();
        System.out.println("Done!");
    }
    //TODO: Create a purchase tracker button that moves you to the purchase tracker page so that you can attach the purchase tracking to the invoice.


    @FXML
    void onCancelClick(ActionEvent event) {
        //FIXME: return to the main window and throw a pop-up that asks if the user truly wants to quite **/
    }

}