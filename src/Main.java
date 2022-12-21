import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class Main extends Application  {

    public static int WIDTH = 800;
    public static int HEIGHT = 800;
    public static Stage PRIMARY_STAGE;
    public static Difficulty selectedDifficulty = Difficulty.NORMAL;
    
    //Not sure weather to keep this viariables in the Snake class and call them or initialize them down below
    int snake_length = 6;                             //initially set blocks for snake body
    int foodEaten = 0;                                //food items eaten by snake initially set to 0
    int snakeFoodX;                                   //x value for snake's food
    int snakeFoodY;                                   //y value for snake's food
    char dir = 'R';                                   //declaring a variable dir for giving our snake direction that is first set to 'R' means our snake initially starts moving to right direction
    boolean running = false;                         //a boolean value for checking condition of our game initially set to false
    Timer timer;                                     //a timer variable from Timer class helps in moving speed of our snake created below by william
    Random random;                                   //a random variable from Random function helps in giving the random location for our snake's food

    // Add such that these variables are dependant on local file.

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception  {
        PRIMARY_STAGE = primaryStage;
        PRIMARY_STAGE.setHeight(HEIGHT);
        PRIMARY_STAGE.setWidth(WIDTH);
        PRIMARY_STAGE.setTitle("Snake Game");
        PRIMARY_STAGE.setResizable(false);
        showMainScene();
        PRIMARY_STAGE.show();
    }

    public void showMainScene() {
        Button startGameButton = createButton("Start Game", WIDTH / 2, (int) (HEIGHT * 0.3));
        startGameButton.setOnAction(event -> {
            showStartGameScene();
        });

        Button settingsButton = createButton("Settings", WIDTH / 2, (int) (HEIGHT * 0.5));
        settingsButton.setOnAction(event -> {
            showSettingsScene();
        });

        Button highScoreButton = createButton("High Score List", WIDTH / 2, (int) (HEIGHT * 0.7));
        highScoreButton.setOnAction(event -> {
            showHighScoreScene();
        });

        Group root = new Group(startGameButton, settingsButton, highScoreButton, quitButton());
        Scene mainScene = new Scene(root, Color.WHITE);
        PRIMARY_STAGE.setScene(mainScene);
    }

    public void draw(Graphics g) {
    /* 
        if (running) { 


            g.setColor(Color.GREEN); //setColor method gave our g Graphics an colour
            g.fillOval(snakeFoodX, snakeFoodY, cellsize, cellsize);

           // for the snake body
            for (int i = 0; i < snake_length; i++) 
            {
                // here i gave my snake's head a different colour from body
                if (i == 0) {
                    g.setColor(Color.red); //setting color to red

                } else {
                    // in next if else block i give two colour to our snake
                    if (i % 2 == 0) {
                        g.setColor(Color.black); //for even blocks of snake's body set black colour
                    } else {
                        g.setColor(Color.black); //else provide white colour to the remaining body
                    }

                }
                g.fillOval(x[i], y[i], cellsize, cellsixe); //and give oval shape
            }
            g.setColor(Color.GREEN); //set colour green
            g.setFont(new Font("Serif", Font.ITALIC, 40)); //setFont method in awt.Graphics class pass a parameter where we declare a new font ("String Font Name",Font.type,int value for size of font)
            FontMetrics metrics = getFontMetrics(g.getFont()); //FontMetrices clas inside awt package is used to encapsulate a given font and here we declare "metrics" as FontMetrices and then get font we gave to g Graphics
            g.drawString("Score: " + foodEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + foodEaten)) / 2, g.getFont().getSize()); //drawString method draw the String on our panel by taking the following parameters("String that we want to draw ",x-length,y-length)
    
        } else {
            gameOver(g); //else if running is false then we go to the gameOver function with parameter g
        }*/
    }

    public void paintComponent(Graphics g) { 
        /*super.paintComponent(g); //create the paintComponent class in which we inherit the method name paintComponent with the help of super keyword nd which perform its function with the help of graphic g that we create and passed in it
        draw(g); //call draw method*/
    }

    public void newFood() {
        /*
        snakeFoodX = random.nextInt((PRIMARY_STAGE.setWidth(WIDTH);/ cellsize)) * UNIT_SIZE; //here it takes x-axis for creating new food for snake through random function
        snakeFoodY = random.nextInt((PRIMARY_STAGE.setHeight(HEIGHT); / cellsize)) * UNIT_SIZE; //here it takes y-axis
        */
    }
   
    //this function now make our snake move
    public void move() {/* 
        for (int i = snake_length; i > 0; i--) { //starting from snake length it continously dec. the values of x and y axis which are arrays where we store the length of snake
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        //switching direction for our snake's movement when we press keys
        switch (dir) {
            case 'U':
                y[0] = y[0] - cellsize; //denote 'U' for Upper direction as decrease y-axis value by one which helps our snake to move in above y-axis
                break;
            case 'D':
                y[0] = y[0] + cellsize;
                break;
            case 'L':
                x[0] = x[0] -  cellsize;
                break;
            case 'R':
                x[0] = x[0] + cellsize;
                break;
        }*/

    }
    public void checkFood() {/* 
        if ((x[0] == snakeFoodX) && (y[0] == snakeFoodY)) { //here as x and y array includes the dimensins of our snake therefore if dimension of head of our snake is equal to the position of food then it must eat it
            snake_length++; //now as our snake eat it's food then we increase snake's length by 1
            foodEaten++; // and also increase the value of food eaten by our snake to one  that will help further in showing score
            newFood(); //and then a call for newFood that will help in generation of newFood for our snake
        } */
    }
   

    public void checkCollisions() {/* 
        //checks if head collides with body
        for (int i = snake_length; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }
        //check if head touches left border
        if (x[0] < 0) {
            running = false;
        }
        //check if head touches right border
        if (x[0] >  PRIMARY_STAGE.setWidth(WIDTH)) {
            running = false;
        }
        //check if head touches top border
        if (y[0] < 0) {
            running = false;
        }
        //check if head touches bottom border
        if (y[0] >  PRIMARY_STAGE.setHeight(HEIGHT)) {
            running = false;
        }

        if (!running) { //check if running is not true then stop timer
            timer.stop();
        }
        */
    }
    public void showStartGameScene() 
    { 
        
        /*//startGame class first run newFood class

        newFood();
        running = true; //sets running to true as through running we define the condition of our game
        timer = new Timer(DELAY, this); 
        timer.start(); //starts the timer that we create from Timer class 
        */


    
        // ADD FUNCTIONALITY
        Button gameButton = createButton("Start Game", WIDTH / 2, (int) (HEIGHT * 0.3));
        gameButton.setOnAction(event -> {
            showGameScene();
        });
        Group root = new Group(gameButton, mainSceneButton(), quitButton());
        Scene startGameScene = new Scene(root, Color.GREEN);
        PRIMARY_STAGE.setScene(startGameScene);
    }

    public void showSettingsScene() { // ADD FUNCTIONALITY
        Group root = new Group(mainSceneButton(), quitButton());
        Scene settingsScene = new Scene(root, Color.BLUE);
        PRIMARY_STAGE.setScene(settingsScene);
    }
   
    public void showHighScoreScene() { // ADD FUNCTIONALITY 
        Group root = new Group(mainSceneButton(), quitButton());
        Scene highScoreScene = new Scene(root, Color.YELLOW);
        PRIMARY_STAGE.setScene(highScoreScene);
    }

    public void showGameScene() {
        int seed = 0;
        int cellcount = 20;
        int cellsize = 40;
        int gridsize = cellcount * cellsize;
        Game game = new Game(seed, cellcount, cellcount, selectedDifficulty); // Fix difficulty later
        Canvas canvas = new Canvas(gridsize, gridsize);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene gameScene = new Scene(root, gridsize, gridsize);
        PRIMARY_STAGE.setScene(gameScene);



        gameScene.setOnKeyPressed(e -> {
            if (Keybind.fromKeypress(e.getCode()) != null) {
                Keybind newDirection = Keybind.fromKeypress(e.getCode());
                switch (newDirection) {
                    case DOWN:
                        if (game.getSnake().getDirection() != Direction.UP) {
                            game.getSnake().setDirection(Direction.DOWN);
                            System.out.println("DOWN");
                        }
                        break;
                    case LEFT:
                        if (game.getSnake().getDirection() != Direction.RIGHT) {
                            game.getSnake().setDirection(Direction.LEFT);
                            System.out.println("LEFT");
                        }
                        break;
                    case RIGHT:
                        if (game.getSnake().getDirection() != Direction.LEFT) {
                            game.getSnake().setDirection(Direction.RIGHT);
                            System.out.println("RIGHT");
                        }
                        break;
                    case UP:
                        if (game.getSnake().getDirection() != Direction.DOWN) {
                            game.getSnake().setDirection(Direction.UP);
                            System.out.println("UP");
                        }
                        break;
                    case PAUSE:
                        // pause
                        break;
                    default:
                        break;
                }
            }
        });
        
        /*public void gameOver(Graphics g) {
        //Score display
        g.setColor(Color.red); //red color for our font graphics
        g.setFont(new Font("Serif", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont()); //again declaring a fontMetrics names as metrics1
        g.drawString("Score: " + foodEaten, (PRIMARY_STAGE.setWidth(WIDTH); - metrics1.stringWidth("Score: " + foodEaten)) / 2, g.getFont().getSize());

        //Game Over display
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (PRIMARY_STAGE.setWidth(WIDTH);- metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
    
        } */

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gc.clearRect(0, 0, gridsize, gridsize);
                gc.setFill(Color.rgb(0, 0, 0));
                gc.fillRect(0, 0, gridsize, gridsize);
                for (int i = 0; i < cellcount; i++) {
                    for (int j = 0; j < cellcount; j++) {
                        GameObject currentGameObject = game.getState()[i][j];
                        gc.setFill(currentGameObject.getColor());
                        gc.fillRect(cellsize * j, cellsize * i, cellsize, cellsize);
                    }
                }
                if(!game.update()) {
                    timer.cancel();
                }
            }
        }, 0, (int) (250 * game.getDifficulty().getSpeedMultiplier()));
    }

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
}
