package com.example.karaokeplayer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RatingController {

    @FXML private Label star1;
    @FXML private Label star2;
    @FXML private Label star3;
    @FXML private Label star4;
    @FXML private Label star5;

    @FXML private Button playAgainButton;
    @FXML private Button chooseAnotherSongButton;
    @FXML private Button quitButton;

    private int currentRating = 0;

    @FXML
    private void initialize() {
        // Setup stars
        setupStar(star1, 1);
        setupStar(star2, 2);
        setupStar(star3, 3);
        setupStar(star4, 4);
        setupStar(star5, 5);

        // Button actions
        playAgainButton.setOnAction(event -> playAgain());
        chooseAnotherSongButton.setOnAction(event -> chooseAnotherSong());
        quitButton.setOnAction(event -> quit());
    }

    private void setupStar(Label star, int ratingValue) {
        star.setOnMouseClicked((MouseEvent event) -> {
            setRating(ratingValue);
        });
    }

    private void setRating(int rating) {
        currentRating = rating;
        Label[] stars = {star1, star2, star3, star4, star5};
        for (int i = 0; i < stars.length; i++) {
            stars[i].setText(i < rating ? "★" : "☆");
        }
        System.out.println("Selected rating: " + currentRating);
    }

    private void playAgain() {
        KaraokePlayerController.getInstance().restartVideo();
        closeStage();
    }

    private void chooseAnotherSong() {
        KaraokePlayerController.getInstance().openFileChooser();
        closeStage();
    }

    private void quit() {
        System.out.println("Quitting application...");
        System.exit(0); // This will terminate the entire application
    }


    private void closeStage() {
        Stage stage = (Stage) playAgainButton.getScene().getWindow();
        stage.close();
    }
}
