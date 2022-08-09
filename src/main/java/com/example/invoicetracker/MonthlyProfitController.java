package com.example.invoicetracker;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MonthlyProfitController {
    @FXML
    private TableView<MonthlyCalculationString> monthlyTable;

    @FXML
    private TableColumn<MonthlyCalculationString,String> monthNameColumn;

    @FXML
    private TableColumn<MonthlyCalculationString,String> numberOfInvoicesColumn;

    @FXML
    private TableColumn<MonthlyCalculationString,String> numberOfLotsColumn;

    @FXML
    private TableColumn<MonthlyCalculationString,String> numberOfPiecesColumn;

    @FXML
    private TableColumn<MonthlyCalculationString,String> monthlyTotalProfitColumn;

    @FXML
    private TableColumn<MonthlyCalculationString,String> monthlyTotalShippingCost;


    FileInputStream invoiceFilePath = new FileInputStream("src/main/java/com/example/invoicetracker/dummyfile.xlsx");

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
        monthList.add(jan);
        monthList.add(feb);
        monthList.add(mar);
        monthList.add(apr);
        monthList.add(may);
        monthList.add(jun);
        monthList.add(jul);
        monthList.add(aug);
        monthList.add(sep);
        monthList.add(oct);
        monthList.add(nov);
        monthList.add(dec);


        Iterator<Row> rowIterator=invoiceSheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext()){
            Row entry = rowIterator.next();
            if(entry.getCell(3)!=null && entry.getCell(3).getCellType() != CellType.BLANK){
                Date date = DateUtil.getJavaDate(entry.getCell(0).getNumericCellValue());
                String pattern = "MM-dd-yy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String strDate = simpleDateFormat.format(date);
                String lots = formatter.formatCellValue(entry.getCell(2));
                String pieces = formatter.formatCellValue(entry.getCell(1));
                String[] strArry = strDate.split("-");
                String month = strArry[0];

                int tempLots = Integer.parseInt(lots);
                int tempPieces = Integer.parseInt(pieces);
                double tempProfit = entry.getCell(9).getNumericCellValue();
                double tempShipping = entry.getCell(7).getNumericCellValue();

                if(Objects.equals(month, "01")){
                    int number = jan.getNumberOfLots()+tempLots;
                    jan.setNumberOfLots(number);
                    jan.setNumberOfPieces(jan.getNumberOfPieces() + tempPieces);
                    jan.setNumberOfInvoices(jan.getNumberOfInvoices() + 1);
                    jan.setShippingTotal(jan.getShippingTotal() + tempShipping);
                    jan.setMonthlyProfit(jan.getMonthlyProfit() + tempProfit);

                }
                if(Objects.equals(month, "02")){
                    feb.setNumberOfLots(feb.getNumberOfLots() + tempLots);
                    feb.setNumberOfPieces(feb.getNumberOfPieces() + tempPieces);
                    feb.setNumberOfInvoices(feb.getNumberOfInvoices() + 1);
                    feb.setShippingTotal(feb.getShippingTotal() + tempShipping);
                    feb.setMonthlyProfit(feb.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "03")){
                    mar.setNumberOfLots(mar.getNumberOfLots() + tempLots);
                    mar.setNumberOfPieces(mar.getNumberOfPieces() + tempPieces);
                    mar.setNumberOfInvoices(mar.getNumberOfInvoices() + 1);
                    mar.setShippingTotal(mar.getShippingTotal() + tempShipping);
                    mar.setMonthlyProfit(mar.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "04")){
                    apr.setNumberOfLots(apr.getNumberOfLots() + tempLots);
                    apr.setNumberOfPieces(apr.getNumberOfPieces() + tempPieces);
                    apr.setNumberOfInvoices(apr.getNumberOfInvoices() + 1);
                    apr.setShippingTotal(apr.getShippingTotal() + tempShipping);
                    apr.setMonthlyProfit(apr.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "05")){
                    may.setNumberOfLots(may.getNumberOfLots() + tempLots);
                    may.setNumberOfPieces(may.getNumberOfPieces() + tempPieces);
                    may.setNumberOfInvoices(may.getNumberOfInvoices() + 1);
                    may.setShippingTotal(may.getShippingTotal() + tempShipping);
                    may.setMonthlyProfit(may.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "06")){
                    jun.setNumberOfLots(jun.getNumberOfLots() + tempLots);
                    jun.setNumberOfPieces(jun.getNumberOfPieces() + tempPieces);
                    jun.setNumberOfInvoices(jun.getNumberOfInvoices() + 1);
                    jun.setShippingTotal(jun.getShippingTotal() + tempShipping);
                    jun.setMonthlyProfit(jun.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "07")){
                    jul.setNumberOfLots(jul.getNumberOfLots() + tempLots);
                    jul.setNumberOfPieces(jul.getNumberOfPieces() + tempPieces);
                    jul.setNumberOfInvoices(jul.getNumberOfInvoices() + 1);
                    jul.setShippingTotal(jul.getShippingTotal() + tempShipping);
                    jul.setMonthlyProfit(jul.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "08")){
                    aug.setNumberOfLots(aug.getNumberOfLots() + tempLots);
                    aug.setNumberOfPieces(aug.getNumberOfPieces() + tempPieces);
                    aug.setNumberOfInvoices(aug.getNumberOfInvoices() + 1);
                    aug.setShippingTotal(aug.getShippingTotal() + tempShipping);
                    aug.setMonthlyProfit(aug.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "09")){
                    sep.setNumberOfLots(sep.getNumberOfLots() + tempLots);
                    sep.setNumberOfPieces(sep.getNumberOfPieces() + tempPieces);
                    sep.setNumberOfInvoices(sep.getNumberOfInvoices() + 1);
                    sep.setShippingTotal(sep.getShippingTotal() + tempShipping);
                    sep.setMonthlyProfit(sep.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "10")){
                    oct.setNumberOfLots(oct.getNumberOfLots() + tempLots);
                    oct.setNumberOfPieces(oct.getNumberOfPieces() + tempPieces);
                    oct.setNumberOfInvoices(oct.getNumberOfInvoices() + 1);
                    oct.setShippingTotal(oct.getShippingTotal() + tempShipping);
                    oct.setMonthlyProfit(oct.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "11")){
                    nov.setNumberOfLots(nov.getNumberOfLots() + tempLots);
                    nov.setNumberOfPieces(nov.getNumberOfPieces() + tempPieces);
                    nov.setNumberOfInvoices(nov.getNumberOfInvoices() + 1);
                    nov.setShippingTotal(nov.getShippingTotal() + tempShipping);
                    nov.setMonthlyProfit(nov.getMonthlyProfit() + tempProfit);
                }
                if(Objects.equals(month, "12")){
                    dec.setNumberOfLots(dec.getNumberOfLots() + tempLots);
                    dec.setNumberOfPieces(dec.getNumberOfPieces() + tempPieces);
                    dec.setNumberOfInvoices(dec.getNumberOfInvoices() + 1);
                    dec.setShippingTotal(dec.getShippingTotal() + tempShipping);
                    dec.setMonthlyProfit(dec.getMonthlyProfit() + tempProfit);
                }
            }

        }
        for(MonthlyCalculation i:monthList){
            String profit = String.valueOf(i.getMonthlyProfit());
            String lots = String.valueOf(i.getNumberOfLots());
            String invoice = String.valueOf(i.getNumberOfInvoices());
            String pieces = String.valueOf(i.getNumberOfPieces());
            String ship = String.valueOf(i.getShippingTotal());
            String name = i.getName();
            MonthlyCalculationString newOne = new MonthlyCalculationString(name,lots,invoice,pieces,ship,profit);
            monthlyTable.getItems().add(newOne);
        }


    }
}
