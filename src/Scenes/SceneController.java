package Scenes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import GameLogic.Game;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController {

    public void switchToSettingsScene(ActionEvent event) throws IOException {
        new SettingsScene().show((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void switchToMainScene(ActionEvent event) throws IOException {
        new MainScene().show((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void switchGameScene(ActionEvent event) throws IOException {
        new GameScene().show((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void switchToGameOverScene(ActionEvent event) throws IOException {
        new GameOverScene().show((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void switchToSelectMapScene(ActionEvent event) throws IOException {
        new MapSelectScene().show((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void exitGameButton(ActionEvent event) throws IOException {
        Platform.exit();
    }





    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider fxSlider;

    @FXML
    private Button easyDifficulty;

    @FXML
    private Button normalDifficulty;

    @FXML
    private Button hardDifficulty;

    @FXML
    private Label scoreLabel;
/*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scoreLabel.setText("ABCasdasd");
    }
*/

    public void printScore(){
        //scoreLabel = new Label("HEJ");
        System.out.println("TEST 123123");
        scoreLabel.setText(GameLogic.Game.getCurrentGameScore()+" points");
    }

  /*  
    @FXML
    public void initialize() {
        scoreLabel = new Label("HEJ");
        scoreLabel.setText("ABCBASDASD");
        System.out.println("TESTAR TESTAR");
    }
*/
    

}
