module org.trucotrato.trucotrato {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.trucotrato.trucotrato to javafx.fxml;
    exports org.trucotrato.trucotrato;
}