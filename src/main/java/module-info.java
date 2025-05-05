module com.example.karaokeplayer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.karaokeplayer to javafx.fxml;
    exports com.example.karaokeplayer;
}