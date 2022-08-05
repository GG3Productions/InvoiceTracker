module com.example.invoicetracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;
    requires jdk.jfr;


    opens com.example.invoicetracker to javafx.fxml;
    exports com.example.invoicetracker;
}