module com.example.moviehubfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    requires com.google.gson;
    opens com.example.moviehubfx to com.google.gson, javafx.fxml;
    exports com.example.moviehubfx;
}