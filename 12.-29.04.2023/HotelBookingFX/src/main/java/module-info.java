module com.example.hotelbookingfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports com.example.hotelbookingfx;
    opens com.example.hotelbookingfx to com.google.gson, javafx.fxml;

    exports com.example.hotelbookingfx.model;
    opens com.example.hotelbookingfx.model to com.google.gson;
}