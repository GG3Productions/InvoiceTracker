package com.example.invoicetracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import static jdk.jfr.consumer.EventStream.openFile;

public class FilePathSelectionController {

    @FXML
    static Button save, invoiceBrowse, purchase1Browse, purchase2Browse;

    @FXML
    static TextField invoicePath;

    @FXML
    static TextField purchasesPath;

    @FXML
    static TextField purchaseTracker;

    @FXML
    void onSaveClick(){
        /*
        TODO: this button should save the paths that have been enter or show the path that is
                currently saved to this option.
         */
    }

    @FXML
    public void onBrowseInvoicePath(){


        new EventHandler<ActionEvent>(){

            final FileChooser fileChooser = new FileChooser();
            Stage stage = new Stage();
            public void handle(final ActionEvent e){
                File file = fileChooser.showOpenDialog(stage);
                if(file!=null){
                    openFile(file);
                }
            }

            private void openFile(File file) {
            }
        };
        /*
        TODO: Make this a file chooser button method
                - ensure the result is sent to the Invoice path
                - ensure that the path is save so that it will open whenever the window is opened

         */
    }

    @FXML
    void onBrowsePurchasePath(){
        /*
        TODO: Make this a file chooser button method
                - ensure the result is sent to the purchase path
                - ensure that the path is save so that it will open whenever the window is opened
         */
    }

    @FXML
    void onBrowsePurchaseTrackerPath(){
        /*
        TODO: Make this a file chooser button method
              - ensure that the result is sent to the purchase tracker path
              - make sure this path is save as to keep it whenever the window is opened up
         */
    }
}
