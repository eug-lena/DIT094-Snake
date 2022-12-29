package Scenes;

import java.io.IOException;
import GameLogic.Difficulty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SettingsScene extends SceneController {
    public void show(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/SettingsScene.fxml"));
        stage.setTitle("Snake Game - Settings");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEasyDifficulty() {
        GameScene.selectedDifficulty = Difficulty.EASY; // be local file later
    }

    public void switchToNormalDifficulty() {
        GameScene.selectedDifficulty = Difficulty.NORMAL; // be local file later
    }

    public void switchToHardDifficulty() {
        GameScene.selectedDifficulty = Difficulty.HARD; // be local file later
    }
}
