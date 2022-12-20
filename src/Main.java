import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Main extends Application {

    public static int WIDTH = 800;
    public static int HEIGHT = 800;
    public static Stage PRIMARY_STAGE;
    public static Difficulty selectedDifficulty = Difficulty.NORMAL;
    // Add such that these variables are dependant on local file.
  

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PRIMARY_STAGE = primaryStage;
        PRIMARY_STAGE.setHeight(HEIGHT);
        PRIMARY_STAGE.setWidth(WIDTH);
        PRIMARY_STAGE.setTitle("Snake Game");
        PRIMARY_STAGE.setResizable(false);
        showMainScene();
        PRIMARY_STAGE.show();
    }

    public void showMainScene() throws IOException { // ADD FUNCTIONALITY
        Parent root = FXMLLoader.load(getClass().getResource("mainMenuScene.fxml"));
        Scene mainScene = new Scene(root);
        PRIMARY_STAGE.setScene(mainScene);
    }


/* 
    public void showMainScene() {
        Button startGameButton = createButton("Start Game", WIDTH / 2, (int) (HEIGHT * 0.3));
        startGameButton.setOnAction(event -> {
            showStartGameScene();
        });

        Button settingsButton = createButton("Settings", WIDTH / 2, (int) (HEIGHT * 0.5));
        settingsButton.setOnAction(event -> {
            try {
                showSettingsScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button highScoreButton = createButton("High Score List", WIDTH / 2, (int) (HEIGHT * 0.7));
        highScoreButton.setOnAction(event -> {
            showHighScoreScene();
        });

        Group root = new Group(startGameButton, settingsButton, highScoreButton, quitButton());
        Scene mainScene = new Scene(root, Color.WHITE);
        PRIMARY_STAGE.setScene(mainScene);
    }

 
    public void showStartGameScene() { // ADD FUNCTIONALITY
        Button gameButton = createButton("Start Game", WIDTH / 2, (int) (HEIGHT * 0.3));
        gameButton.setOnAction(event -> {
            showGameScene();
        });
        Group root = new Group(gameButton, mainSceneButton(), quitButton());
        Scene startGameScene = new Scene(root, Color.GREEN);
        PRIMARY_STAGE.setScene(startGameScene);
    }
    

    public void showSettingsScene() throws IOException { // ADD FUNCTIONALITY
        Parent root = FXMLLoader.load(getClass().getResource("SettingsScene.fxml"));
        Scene settingsScene = new Scene(root);
        PRIMARY_STAGE.setScene(settingsScene);
    }

    public void showHighScoreScene() { // ADD FUNCTIONALITY
        Group root = new Group(mainSceneButton(), quitButton());
        Scene highScoreScene = new Scene(root, Color.YELLOW);
        PRIMARY_STAGE.setScene(highScoreScene);
    }
*/
    public void showGameScene() {
        int cellcount = 20;
        int cellsize = 40;
        int gridsize = cellcount * cellsize;
        Game game = new Game(cellcount, cellsize, gridsize, selectedDifficulty); // Fix difficulty later
        Canvas canvas = new Canvas(gridsize, gridsize);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane root = new StackPane(canvas);
        Scene gameScene = new Scene(root, gridsize, gridsize);
        PRIMARY_STAGE.setScene(gameScene);
        
        //PRIMARY_STAGE.sizeToScene();
        gameScene.setOnKeyPressed(e -> {
            if (Direction.fromKeypress(e.getCode()) != null) {
                Direction newDirection = Direction.fromKeypress(e.getCode());
                switch (newDirection) {
                    case DOWN:
                        if (game.snake.getDirection() != Direction.UP) {
                            game.snake.updateDirection(Direction.DOWN);
                            System.out.println("DOWN");
                        }
                        break;
                    case LEFT:
                        if (game.snake.getDirection() != Direction.RIGHT) {
                            game.snake.updateDirection(Direction.LEFT);
                            System.out.println("LEFT");
                        }
                        break;
                    case RIGHT:
                        if (game.snake.getDirection() != Direction.LEFT) {
                            game.snake.updateDirection(Direction.RIGHT);
                            System.out.println("RIGHT");
                        }
                        break;
                    case UP:
                        if (game.snake.getDirection() != Direction.DOWN) {
                            game.snake.updateDirection(Direction.UP);
                            System.out.println("UP");
                        }
                        break;
                    default:
                        break;
                }
            }
        });

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("RUN");
            }
        }, 0, 5000);

        new AnimationTimer() {
            public void handle(long now) {
                for (int i = 0; i < cellcount; i++) {
                    for (int j = 0; j < cellcount; j++) {
                        GameObject currentGameObject;
                        if (game.grid[i][j] instanceof EmptyGameObject) {
                            currentGameObject = new EmptyGameObject();
                            gc.setFill(Color.rgb(
                                    currentGameObject.getRed(),
                                    currentGameObject.getGreen(),
                                    currentGameObject.getBlue()));
                            gc.fillRect(cellsize * j, cellsize * i, cellsize, cellsize);
                        }
                    }
                }
            }
        }.start();
    }
/* 
    public Button createButton(String text, int XPos, int YPos) {
        int buttonWidth = WIDTH / 3; // Can make resolution be enums, then have this based on that.
        int buttonHeight = HEIGHT / 10;
        Button button = new Button(text);
        button.setTranslateX(XPos - buttonWidth / 2);
        button.setTranslateY(YPos - buttonHeight / 2);
        button.setMinWidth(buttonWidth);
        button.setMinHeight(buttonHeight);
        return button;
    }

    public Button mainSceneButton() {
        Button mainSceneButton = createButton("Go back to main scene", WIDTH / 6, HEIGHT - HEIGHT / 10);
        mainSceneButton.setOnAction(event -> {
            showMainScene();
        });
        return mainSceneButton;
    }
    

    public Button quitButton() {
        Button quitButton = createButton("Exit program", WIDTH - WIDTH / 6, HEIGHT - HEIGHT / 10);
        quitButton.setOnAction(event -> {
            Platform.exit();
        });
        quitButton.setStyle("-fx-background-color: #ff8080; ");
        return quitButton;
    }
    */
}
