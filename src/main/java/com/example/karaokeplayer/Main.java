package com.example.karaokeplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Load the landing page FXML instead of media player FXML
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("landing-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Image logo = new Image(getClass().getResourceAsStream("MicLogo.jpg"));
        stage.getIcons().add(logo);
        stage.setResizable(false);


        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
