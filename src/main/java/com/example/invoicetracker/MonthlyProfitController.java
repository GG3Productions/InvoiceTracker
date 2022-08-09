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
        numberOfLotsColumn.setCellValueFactory(new PropertyValueFactory<>("lots"));
        numberOfPiecesColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPieces"));
        monthlyTotalProfitColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyProfit"));
        monthlyTotalShippingCost.setCellValueFactory(new PropertyValueFactory<>("shippingTotal"));
        numberOfInvoicesColumn.setCellValueFactory(new PropertyValueFactory<>("invoice"));

        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        DataFormatter formatter = new DataFormatter();
        FormulaEvaluator evaluator = invoiceWorkbook.getCreationHelper().createFormulaEvaluator();
        DecimalFormat df = new DecimalFormat("#.##");


        MonthlyCalculation jan = new MonthlyCalculation(0,0,0,0,"January");
        MonthlyCalculation feb = new MonthlyCalculation(0,0,0,0,"February");
        MonthlyCalculation mar = new MonthlyCalculation(0,0,0,0,"March");
        MonthlyCalculation apr = new MonthlyCalculation(0,0,0,0,"April");
        MonthlyCalculation may = new MonthlyCalculation(0,0,0,0,"May");
        MonthlyCalculation jun = new MonthlyCalculation(0,0,0,0,"June");
        MonthlyCalculation jul = new MonthlyCalculation(0,0,0,0,"July");
        MonthlyCalculation aug = new MonthlyCalculation(0,0,0,0,"August");
        MonthlyCalculation sep = new MonthlyCalculation(0,0,0,0,"September");
        MonthlyCalculation oct = new MonthlyCalculation(0,0,0,0,"October");
        MonthlyCalculation nov = new MonthlyCalculation(0,0,0,0,"November");
        MonthlyCalculation dec = new MonthlyCalculation(0,0,0,0,"December");

        List<MonthlyCalculation> monthList = new ArrayList<>();
        Collections.addAll(monthList,jan,feb,mar,apr,may,jun,jul,aug,sep,oct,nov,dec);

        List<Integer> invoiceList = new ArrayList<>();
        Collections.addAll(invoiceList,0,0,0,0,0,0,0,0,0,0,0,0);

        Iterator<Row> rowIterator=invoiceSheet.iterator();
        rowIterator.next();
        while(rowIterator.hasNext()){
            Row entry = rowIterator.next();
            if(entry.getCell(3)!=null && entry.getCell(3).getCellType() != CellType.BLANK){
                Date date = DateUtil.getJavaDate(entry.getCell(0).getNumericCellValue());
                String pattern = "MM-dd-yy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String strDate = simpleDateFormat.format(date);
                String[] strArry = strDate.split("-");
                String month = strArry[0];

                String lots = formatter.formatCellValue(entry.getCell(2));

                int tempLots = Integer.parseInt(lots);
                int tempPieces = (int)entry.getCell(1).getNumericCellValue();
                double tempProfit = entry.getCell(9).getNumericCellValue();
                double tempShipping = entry.getCell(7).getNumericCellValue();


                if(Objects.equals(month, "01")){
                    jan.setNumberOfLots(jan.getNumberOfLots()+  tempLots);
                    jan.setNumberOfPieces(jan.getNumberOfPieces() + tempPieces);
                    jan.setShippingTotal(jan.getShippingTotal() + tempShipping);
                    jan.setMonthlyProfit(jan.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(0);
                    invoiceList.set(0,tempInvoice+1);

                }
                if(Objects.equals(month, "02")){
                    feb.setNumberOfLots(feb.getNumberOfLots() + tempLots);
                    feb.setNumberOfPieces(feb.getNumberOfPieces() + tempPieces);
                    feb.setShippingTotal(feb.getShippingTotal() + tempShipping);
                    feb.setMonthlyProfit(feb.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(1);
                    invoiceList.set(1,tempInvoice+1);
                }
                if(Objects.equals(month, "03")){
                    mar.setNumberOfLots(mar.getNumberOfLots() + tempLots);
                    mar.setNumberOfPieces(mar.getNumberOfPieces() + tempPieces);
                    mar.setShippingTotal(mar.getShippingTotal() + tempShipping);
                    mar.setMonthlyProfit(mar.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(2);
                    invoiceList.set(2,tempInvoice+1);
                }
                if(Objects.equals(month, "04")){
                    apr.setNumberOfLots(apr.getNumberOfLots() + tempLots);
                    apr.setNumberOfPieces(apr.getNumberOfPieces() + tempPieces);
                    apr.setShippingTotal(apr.getShippingTotal() + tempShipping);
                    apr.setMonthlyProfit(apr.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(3);
                    invoiceList.set(3,tempInvoice+1);
                }
                if(Objects.equals(month, "05")){
                    may.setNumberOfLots(may.getNumberOfLots() + tempLots);
                    may.setNumberOfPieces(may.getNumberOfPieces() + tempPieces);
                    may.setShippingTotal(may.getShippingTotal() + tempShipping);
                    may.setMonthlyProfit(may.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(4);
                    invoiceList.set(4,tempInvoice+1);
                }
                if(Objects.equals(month, "06")){
                    jun.setNumberOfLots(jun.getNumberOfLots() + tempLots);
                    jun.setNumberOfPieces(jun.getNumberOfPieces() + tempPieces);
                    jun.setShippingTotal(jun.getShippingTotal() + tempShipping);
                    jun.setMonthlyProfit(jun.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(5);
                    invoiceList.set(5,tempInvoice+1);
                }
                if(Objects.equals(month, "07")){
                    jul.setNumberOfLots(jul.getNumberOfLots() + tempLots);
                    jul.setNumberOfPieces(jul.getNumberOfPieces() + tempPieces);
                    jul.setShippingTotal(jul.getShippingTotal() + tempShipping);
                    jul.setMonthlyProfit(jul.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(6);
                    invoiceList.set(6,tempInvoice+1);
                }
                if(Objects.equals(month, "08")){
                    aug.setNumberOfLots(aug.getNumberOfLots() + tempLots);
                    aug.setNumberOfPieces(aug.getNumberOfPieces() + tempPieces);
                    aug.setShippingTotal(aug.getShippingTotal() + tempShipping);
                    aug.setMonthlyProfit(aug.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(7);
                    invoiceList.set(7,tempInvoice+1);
                }
                if(Objects.equals(month, "09")){
                    sep.setNumberOfLots(sep.getNumberOfLots() + tempLots);
                    sep.setNumberOfPieces(sep.getNumberOfPieces() + tempPieces);
                    sep.setShippingTotal(sep.getShippingTotal() + tempShipping);
                    sep.setMonthlyProfit(sep.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(8);
                    invoiceList.set(8,tempInvoice+1);
                }
                if(Objects.equals(month, "10")){
                    oct.setNumberOfLots(oct.getNumberOfLots() + tempLots);
                    oct.setNumberOfPieces(oct.getNumberOfPieces() + tempPieces);
                    oct.setShippingTotal(oct.getShippingTotal() + tempShipping);
                    oct.setMonthlyProfit(oct.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(9);
                    invoiceList.set(9,tempInvoice+1);
                }
                if(Objects.equals(month, "11")){
                    nov.setNumberOfLots(nov.getNumberOfLots() + tempLots);
                    nov.setNumberOfPieces(nov.getNumberOfPieces() + tempPieces);
                    nov.setShippingTotal(nov.getShippingTotal() + tempShipping);
                    nov.setMonthlyProfit(nov.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(10);
                    invoiceList.set(10,tempInvoice+1);
                }
                if(Objects.equals(month, "12")){
                    dec.setNumberOfLots(dec.getNumberOfLots() + tempLots);
                    dec.setNumberOfPieces(dec.getNumberOfPieces() + tempPieces);
                    dec.setShippingTotal(dec.getShippingTotal() + tempShipping);
                    dec.setMonthlyProfit(dec.getMonthlyProfit() + tempProfit);
                    int tempInvoice = invoiceList.get(11);
                    invoiceList.set(11,tempInvoice+1);
                }
            }

        }

        // this takes the month object from the array list and converts it to a string and adds it to table view
        int num = 0;
        for(MonthlyCalculation i:monthList){
            String profit = String.valueOf(i.getMonthlyProfit());
            String lots = String.valueOf(i.getNumberOfLots());
            String pieces = String.valueOf(i.getNumberOfPieces());
            String ship = String.valueOf(i.getShippingTotal());
            String name = i.getName();
            String invoice = String.valueOf(invoiceList.get(num));
            MonthlyCalculationString newOne = new MonthlyCalculationString(name,lots,pieces,ship,profit,invoice);
            monthlyTable.getItems().add(newOne);
            num++;
        }


    }
}
