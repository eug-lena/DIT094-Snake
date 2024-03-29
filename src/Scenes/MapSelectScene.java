package Scenes;

import java.io.IOException;

import GameLogic.FileHandler;
import GameLogic.Layout;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MapSelectScene extends SceneController {
    public void show(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/SelectMapScene.fxml"));
        stage.setTitle("Snake Game - Map Selection");
        stage.setScene(new Scene(root));
        stage.show();
    }

    // Functions to swap map for the buttons.
    // First change map in the GameData.json.
    // Then re-initialize the scene to have the button states update to be correct.
    public void switchToOrdinaryLayout(ActionEvent event) throws IOException {
        FileHandler.updateGameLayout(Layout.ORDINARY);
        switchToSelectMapScene(event);
    }

    public void switchToBlankLayout(ActionEvent event) throws IOException {
        FileHandler.updateGameLayout(Layout.BLANK);
        switchToSelectMapScene(event);
    }

    public void switchToBorderedPlusLayout(ActionEvent event) throws IOException {
        FileHandler.updateGameLayout(Layout.BORDERED_PLUS);
        switchToSelectMapScene(event);
    }

    public void switchToUnborderedPlusLayout(ActionEvent event) throws IOException {
        FileHandler.updateGameLayout(Layout.UNBORDERED_PLUS);
        switchToSelectMapScene(event);
    }

    public void switchToBorderedOctagonLayout(ActionEvent event) throws IOException {
        FileHandler.updateGameLayout(Layout.BORDERED_OCTAGON);
        switchToSelectMapScene(event);
    }

    public void switchToUnborderedOctagonLayout(ActionEvent event) throws IOException {
        FileHandler.updateGameLayout(Layout.UNBORDERED_OCTAGON);
        switchToSelectMapScene(event);
    }

    // Makes the selected map stand out
    public void initialize() {
        switch (FileHandler.readGameLayout()) {
            case ORDINARY:
                ordinaryMap.setStyle("-fx-border-style: outset ; ");
                break;
            case BORDERED_PLUS:
                borderedPlusMap.setStyle("-fx-border-style: outset ; ");
                break;
            case BORDERED_OCTAGON:
                borderedOctagonMap.setStyle("-fx-border-style: outset ; ");
                break;
            case BLANK:
                blankMap.setStyle("-fx-border-style: outset ; ");
                break;
            case UNBORDERED_PLUS:
                unborderedPlusMap.setStyle("-fx-border-style: outset ; ");
                break;
            case UNBORDERED_OCTAGON:
                unborderedOctagonMap.setStyle("-fx-border-style: outset ; ");
                break;
            default:
                break;
        }
    }

    @FXML
    private Button ordinaryMap;

    @FXML
    private Button borderedPlusMap;

    @FXML
    private Button unborderedPlusMap;

    @FXML
    private Button borderedOctagonMap;

    @FXML
    private Button unborderedOctagonMap;

    @FXML
    private Button blankMap;
}
