module com.example.traintripfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports com.example.traintripfx;
    opens com.example.traintripfx to com.google.gson, javafx.fxml;

    exports com.example.traintripfx.model;
    opens com.example.traintripfx.model to com.google.gson;
}