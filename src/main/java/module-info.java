module com.example.csc325module5assigmnet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc325module5assigmnet to javafx.fxml;
    exports com.example.csc325module5assigmnet;
}