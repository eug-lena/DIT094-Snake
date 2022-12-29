package Scenes;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainScene extends SceneController {
    public void show(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/mainMenuScene.fxml"));
        stage.setTitle("Snake Game");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
