module sample.ecommerce {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sample.ecommerce to javafx.fxml;
    exports sample.ecommerce;
}