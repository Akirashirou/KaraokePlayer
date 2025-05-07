package com.example.karaokeplayer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class MediaPlayer {

    @FXML
    void enterPlayer(ActionEvent event) throws IOException {
        // Load the media player FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("media-player.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Get the current stage (window) that called this action
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Set the new scene to the stage
        stage.setScene(scene);
        stage.setTitle("Karaoke Player");

        // Make sure the stage is resizable
        stage.setResizable(true);

        // Show the new stage
        stage.show();
    }
}
