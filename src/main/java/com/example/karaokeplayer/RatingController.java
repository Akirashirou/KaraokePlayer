package com.example.karaokeplayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Random;

public class RatingController {

    @FXML private Label star1;
    @FXML private Label star2;
    @FXML private Label star3;
    @FXML private Label star4;
    @FXML private Label star5;

    @FXML private Button playAgainButton;
    @FXML private Button chooseAnotherSongButton;
    @FXML private Button quitButton;

    @FXML
    private void initialize() {
        showRandomRating();

        playAgainButton.setOnAction(event -> playAgain());
        chooseAnotherSongButton.setOnAction(event -> chooseAnotherSong());
        quitButton.setOnAction(event -> quit());
    }

    private void showRandomRating() {
        Random random = new Random();
        int rating = random.nextInt(5) + 1; // Random number from 1 to 5

        Label[] stars = {star1, star2, star3, star4, star5};

        for (int i = 0; i < stars.length; i++) {
            if (i < rating) {
                stars[i].setText("⭐");
                stars[i].setStyle("-fx-text-fill: black; -fx-font-size: 24px;");
            } else {
                stars[i].setText("☆");
                stars[i].setStyle("-fx-text-fill: gray; -fx-font-size: 24px;");
            }
        }
    }


    private void playAgain() {
        KaraokePlayerController controller = KaraokePlayerController.getInstance();
        if(controller != null){
            controller.restartVideo();
        }
        closeStage();
    }

    private void chooseAnotherSong() {
        KaraokePlayerController controller = KaraokePlayerController.getInstance();
        if(controller != null){
            controller.openFileChooser();
        }
        closeStage();
    }

    private void quit() {
        System.exit(0);
    }

    private void closeStage() {
        Stage stage = (Stage) playAgainButton.getScene().getWindow();
        stage.close();
    }
}
