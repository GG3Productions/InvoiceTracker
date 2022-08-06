package com.example.invoicetracker;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MonthlyProfitController {
    @FXML
    private TableView monthlyTable;

    @FXML
    private TableColumn<MonthlyCalculation,String> monthNameColumn;

    @FXML
    private TableColumn<MonthlyCalculation,Integer> numberOfInvoicesColumn;

    @FXML
    private TableColumn<MonthlyCalculation,Integer> numberOfLotsColumn;

    @FXML
    private TableColumn<MonthlyCalculation,Integer> numberOfPiecesColumn;

    @FXML
    private TableColumn<MonthlyCalculation,String> monthlyTotalProfitColumn;

    @FXML
    private TableColumn<MonthlyCalculation,String> monthlyTotalShippingCost;


    FileInputStream invoiceFilePath = new FileInputStream("C:\\Users\\MGU31\\Invoice file .xlsx");

    public MonthlyProfitController() throws FileNotFoundException {
    }

    @FXML
    void onRefreshMonthlyClick() throws IOException {
        XSSFWorkbook invoiceWorkbook = new XSSFWorkbook(invoiceFilePath);
        XSSFSheet invoiceSheet = invoiceWorkbook.getSheetAt(0);

        monthNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        numberOfInvoicesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfInvoices"));
        numberOfLotsColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfLots"));
        numberOfPiecesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPieces"));
        monthlyTotalProfitColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyProfit"));
        monthlyTotalShippingCost.setCellValueFactory(new PropertyValueFactory<>("shippingTotal"));

        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        DataFormatter formatter = new DataFormatter();
        FormulaEvaluator evaluator = invoiceWorkbook.getCreationHelper().createFormulaEvaluator();
        DecimalFormat df = new DecimalFormat("#.##");


        MonthlyCalculation jan = new MonthlyCalculation(0,0,0,0,0,"January");
        MonthlyCalculation feb = new MonthlyCalculation(0,0,0,0,0,"February");
        MonthlyCalculation mar = new MonthlyCalculation(0,0,0,0,0,"March");
        MonthlyCalculation apr = new MonthlyCalculation(0,0,0,0,0,"April");
        MonthlyCalculation may = new MonthlyCalculation(0,0,0,0,0,"May");
        MonthlyCalculation jun = new MonthlyCalculation(0,0,0,0,0,"June");
        MonthlyCalculation jul = new MonthlyCalculation(0,0,0,0,0,"July");
        MonthlyCalculation aug = new MonthlyCalculation(0,0,0,0,0,"August");
        MonthlyCalculation sep = new MonthlyCalculation(0,0,0,0,0,"September");
        MonthlyCalculation oct = new MonthlyCalculation(0,0,0,0,0,"October");
        MonthlyCalculation nov = new MonthlyCalculation(0,0,0,0,0,"November");
        MonthlyCalculation dec = new MonthlyCalculation(0,0,0,0,0,"December");

        List<MonthlyCalculation> monthList = new ArrayList<>();

        Iterator<Row> rowIterator=invoiceSheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext()){
            Row entry = rowIterator.next();
            if(entry.getCell(3)!=null && entry.getCell(3).getCellType() != CellType.BLANK){
                String month = sdf.format(entry.getCell(1).getDateCellValue());
                String lots = formatter.formatCellValue(entry.getCell(2));
                String pieces = formatter.formatCellValue(entry.getCell(1));

                int tempLots = Integer.parseInt(lots);
                int tempPieces = Integer.parseInt(pieces);
                double tempProfit = entry.getCell(9).getNumericCellValue();
                double tempShipping = entry.getCell(7).getNumericCellValue();

                if(month == "01"){
                    jan.setNumberOfLots(jan.getNumberOfLots() + tempLots);
                    jan.setNumberOfPieces(jan.getNumberOfPieces() + tempPieces);
                    jan.setNumberOfInvoices(jan.getNumberOfInvoices() + 1);
                    jan.setShippingTotal(jan.getShippingTotal() + tempShipping);
                    jan.setMonthlyProfit(jan.getMonthlyProfit() + tempProfit);

                }
                if(month == "02"){
                    feb.setNumberOfLots(feb.getNumberOfLots() + tempLots);
                    feb.setNumberOfPieces(feb.getNumberOfPieces() + tempPieces);
                    feb.setNumberOfInvoices(feb.getNumberOfInvoices() + 1);
                    feb.setShippingTotal(feb.getShippingTotal() + tempShipping);
                    feb.setMonthlyProfit(feb.getMonthlyProfit() + tempProfit);
                }
                if(month == "03"){
                    mar.setNumberOfLots(mar.getNumberOfLots() + tempLots);
                    mar.setNumberOfPieces(mar.getNumberOfPieces() + tempPieces);
                    mar.setNumberOfInvoices(mar.getNumberOfInvoices() + 1);
                    mar.setShippingTotal(mar.getShippingTotal() + tempShipping);
                    mar.setMonthlyProfit(mar.getMonthlyProfit() + tempProfit);
                }
                if(month == "04"){
                    apr.setNumberOfLots(apr.getNumberOfLots() + tempLots);
                    apr.setNumberOfPieces(apr.getNumberOfPieces() + tempPieces);
                    apr.setNumberOfInvoices(apr.getNumberOfInvoices() + 1);
                    apr.setShippingTotal(apr.getShippingTotal() + tempShipping);
                    apr.setMonthlyProfit(apr.getMonthlyProfit() + tempProfit);
                }
                if(month == "05"){
                    may.setNumberOfLots(may.getNumberOfLots() + tempLots);
                    may.setNumberOfPieces(may.getNumberOfPieces() + tempPieces);
                    may.setNumberOfInvoices(may.getNumberOfInvoices() + 1);
                    may.setShippingTotal(may.getShippingTotal() + tempShipping);
                    may.setMonthlyProfit(may.getMonthlyProfit() + tempProfit);
                }
                if(month == "06"){
                    jun.setNumberOfLots(jun.getNumberOfLots() + tempLots);
                    jun.setNumberOfPieces(jun.getNumberOfPieces() + tempPieces);
                    jun.setNumberOfInvoices(jun.getNumberOfInvoices() + 1);
                    jun.setShippingTotal(jun.getShippingTotal() + tempShipping);
                    jun.setMonthlyProfit(jun.getMonthlyProfit() + tempProfit);
                }
                if(month == "07"){
                    jul.setNumberOfLots(jul.getNumberOfLots() + tempLots);
                    jul.setNumberOfPieces(jul.getNumberOfPieces() + tempPieces);
                    jul.setNumberOfInvoices(jul.getNumberOfInvoices() + 1);
                    jul.setShippingTotal(jul.getShippingTotal() + tempShipping);
                    jul.setMonthlyProfit(jul.getMonthlyProfit() + tempProfit);
                }
                if(month == "08"){
                    aug.setNumberOfLots(aug.getNumberOfLots() + tempLots);
                    aug.setNumberOfPieces(aug.getNumberOfPieces() + tempPieces);
                    aug.setNumberOfInvoices(aug.getNumberOfInvoices() + 1);
                    aug.setShippingTotal(aug.getShippingTotal() + tempShipping);
                    aug.setMonthlyProfit(aug.getMonthlyProfit() + tempProfit);
                }
                if(month == "09"){
                    sep.setNumberOfLots(sep.getNumberOfLots() + tempLots);
                    sep.setNumberOfPieces(sep.getNumberOfPieces() + tempPieces);
                    sep.setNumberOfInvoices(sep.getNumberOfInvoices() + 1);
                    sep.setShippingTotal(sep.getShippingTotal() + tempShipping);
                    sep.setMonthlyProfit(sep.getMonthlyProfit() + tempProfit);
                }
                if(month == "10"){
                    oct.setNumberOfLots(oct.getNumberOfLots() + tempLots);
                    oct.setNumberOfPieces(oct.getNumberOfPieces() + tempPieces);
                    oct.setNumberOfInvoices(oct.getNumberOfInvoices() + 1);
                    oct.setShippingTotal(oct.getShippingTotal() + tempShipping);
                    oct.setMonthlyProfit(oct.getMonthlyProfit() + tempProfit);
                }
                if(month == "11"){
                    nov.setNumberOfLots(nov.getNumberOfLots() + tempLots);
                    nov.setNumberOfPieces(nov.getNumberOfPieces() + tempPieces);
                    nov.setNumberOfInvoices(nov.getNumberOfInvoices() + 1);
                    nov.setShippingTotal(nov.getShippingTotal() + tempShipping);
                    nov.setMonthlyProfit(nov.getMonthlyProfit() + tempProfit);
                }
                if(month == "12"){
                    dec.setNumberOfLots(dec.getNumberOfLots() + tempLots);
                    dec.setNumberOfPieces(dec.getNumberOfPieces() + tempPieces);
                    dec.setNumberOfInvoices(dec.getNumberOfInvoices() + 1);
                    dec.setShippingTotal(dec.getShippingTotal() + tempShipping);
                    dec.setMonthlyProfit(dec.getMonthlyProfit() + tempProfit);
                }
            }

        }



    }
}
