module com.example.invoicetracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.invoicetracker to javafx.fxml;
    exports com.example.invoicetracker;
}