import Scenes.MainScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        new MainScene().show(stage);
    }

    /*
     * public void showHighScoreScene() { // ADD FUNCTIONALITY
     * 
     * Text text = new Text();
     * text.setText("High Scores");
     * 
     * int xPOS=225;
     * int yPOS=75;
     * text.setX(xPOS);
     * text.setY(yPOS);
     * text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
     * 
     * Group root = new Group(mainSceneButton(), quitButton(), text);
     * //Scene highScoreScene = new Scene(vBox, Color.YELLOW);
     * PRIMARY_STAGE.setScene(new Scene(root,800,800));
     * }
     */

}
