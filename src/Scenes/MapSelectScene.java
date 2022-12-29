package Scenes;
import java.io.IOException;
import GameLogic.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MapSelectScene extends SceneController {
    public void show(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/SelectMapScene.fxml"));
        stage.setTitle("Snake Game - Map Selection");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToNormalLayout() {
        Game.setCurrentLayout(Game.Layout.ORDINARY); // be local file later
    }

    public void switchToPlusLayout() {
        Game.setCurrentLayout(Game.Layout.PLUS); // be local file later
    }
}
