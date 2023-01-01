package GameLogic;

import GameLogic.GameObjects.*;

public class Game {
    public static String playerName;
    
    // Should be local file

    public enum Layout { // there is a scene built where the user can choose between these. If you update
                         // and add more OR remove please mention it so that the correlating scene can be
                         // edited
        ORDINARY,
        PLUS,
        OCTAGON
    }

    private Snake snake;
    private Layout layout;
    private int width;
    private int height;
    private GameObject[][] grid;
    private Difficulty difficulty;
    private Boolean pausedGame;
    private double currentGameScore;
    

    public Game(int width, int height) {
        FileHandler fh = new FileHandler();
        this.pausedGame = true;
        this.currentGameScore = 0;
        this.snake = new Snake(width / 2, height / 2);
        this.width = width;
        this.height = height;
        this.layout = fh.readGameLayout();
        this.difficulty = fh.readGameDifficulty();
        fh.updateCurrentScore(0);
        this.grid = generateMap();
        generateFruit();
    }

    public GameObject[][] generateMap() {
        GameObject[][] gameGrid;
        switch (this.layout) {
            case ORDINARY:
                gameGrid = generateOrdinaryMap();
                break;
            case PLUS:
                gameGrid = generatePlusMap();
                break;
            case OCTAGON:
                gameGrid = generateOctagonMap();
                break;
            default:
                gameGrid = null;
                break;
        }

        gameGrid[this.snake.getRow(0)][this.snake.getColumn(0)] = new SnakeSegment(true);
        for (int i = 1; i < this.snake.getBody().size(); i++) {
            gameGrid[this.snake.getRow(i)][this.snake.getColumn(i)] = new SnakeSegment();
        }
        return gameGrid;
    }

    private GameObject[][] generateOrdinaryMap() {
        GameObject[][] normalGameGrid = new GameObject[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (i % (height - 1) == 0 || j % (width - 1) == 0) {
                    // If i or j == lowest or highest value, it is a border (WallGameObject).
                    // 0 = lowest value, 0 % X == 0 > where X is any number.
                    // height/width = highest value, - 1 since array start at 0.
                    normalGameGrid[i][j] = new WallGameObject();
                } else {
                    normalGameGrid[i][j] = new EmptyGameObject();
                }
            }
        }
        return normalGameGrid;
    }

    private GameObject[][] generatePlusMap() {
        GameObject[][] plusGameGrid = generateOrdinaryMap();
        // To get the initial border-walls.
        int widthGap = this.width / 4;
        int heightGap = this.height / 4;

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (!((i + heightGap < this.height - 1 && i - heightGap > 0)
                        || (j + widthGap < this.width - 1 && j - widthGap > 0))) {
                    plusGameGrid[i][j] = new WallGameObject();
                }
            }
        }
        return plusGameGrid;
    }


    // kinda bad implementation but it works
    // feel free to improve it otherwise I'll do it another time

    private GameObject[][] generateOctagonMap() {
        GameObject[][] octagonGameGrid = generateOrdinaryMap();
        // To get the initial border-walls.
        int upperWidthGap = this.width / 3;
        int upperHeightGap = this.height / 3;
        int lowerWidthGap = this.width - upperWidthGap;
        int lowerHeightGap = this.height - upperHeightGap;

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if(((i<upperHeightGap && i+j<upperHeightGap)||(j<upperWidthGap && i+j<upperWidthGap))
                || ((i>lowerHeightGap && i-j>=lowerHeightGap)&&(j<upperWidthGap && i-j>=lowerHeightGap))
                || ((i<upperHeightGap && j-i>=lowerWidthGap)&&(j>lowerWidthGap && j-i>=lowerWidthGap))
                || ((i>lowerHeightGap && i+j>=this.height+lowerHeightGap-1)&&(j>lowerWidthGap && i+j>=this.width+lowerWidthGap-1))) {
                    
                     octagonGameGrid[i][j] = new WallGameObject();
                }
            }
        }
        return octagonGameGrid;
	}

    public boolean update() {
        if (!pausedGame) {
            // If pausedGame == false; the game will update.
            // Otherwise nothing will happen, it is "paused".

            if (predictMovement() instanceof WallGameObject || predictMovement() instanceof SnakeSegment) {
                // Game Over, return false to indicate that to the GameScene.
                return false;
            } else if (predictMovement() instanceof FruitGameObject) {
                // growSnake() and increase score, then move.
                Scenes.Audio.play("audio/Eat.wav");
                this.snake.growSnake(this.snake.getRow(this.snake.getBody().size() - 1), this.snake
                        .getColumn(this.snake.getBody().size() - 1));
                this.currentGameScore = this.currentGameScore + difficulty.getScoreMultiplier();
                new FileHandler().updateCurrentScore(this.currentGameScore);
                generateFruit();
            } else {
                // else = instanceof EmptyGameObject, clean up the tail then move.
                this.grid[this.snake.getRow(this.snake.getBody().size() - 1)][this.snake
                        .getColumn(this.snake.getBody().size() - 1)] = new EmptyGameObject();
            }
            // predictMovement() predicts the next upcoming GameObject depending on the
            // direction. Then different upcoming GameObject have different logic what
            // will incur if the snake head collide with it.

            for (int i = this.snake.getBody().size() - 1; i > 0; i--) {
                this.snake.setPosition(i, this.snake.getRow(i - 1), this.snake.getColumn(i - 1));
                this.grid[this.snake.getRow(i)][this.snake.getColumn(i)] = new SnakeSegment();
            }
            // Move the entire body except the head.
            // Each part takes the position of the preceding one.

            this.snake.setPosition(0, predictRow(), predictColumn());
            this.grid[this.snake.getRow(0)][this.snake.getColumn(0)] = new SnakeSegment(true);
            // The "0" argument indicates the head, as its the first in the arraylist.
            // Unique movement for the head, as it is dependant on the direction.
        }
        return true;

    }

    public void generateFruit() {
        // Randoms a position until it find a EmptyGameObject on the grid,
        // then make it into a FruitGameObject instead.
        boolean createdFruit = true;
        while (createdFruit) {
            int row = (int) (Math.random() * height);
            int column = (int) (Math.random() * width);
            if (this.grid[row][column] instanceof EmptyGameObject) {
                this.grid[row][column] = new FruitGameObject();
                createdFruit = false;
            }
        }
    }

    public boolean getPausedGame() {
        return this.pausedGame;
    }

    public void pauseToggle() {
        // Changes the value to the oposite everytime the pause-key is pressed,
        // making the game able to pause and unpause.
        this.pausedGame = !this.pausedGame;
    }

    public int[] predictCoordinates() {
        // Predicts the next position of the snake head depending on the direction.
        switch (this.snake.getDirection()) {
            case DOWN:
                return new int[] { this.snake.getRow(0) + 1, this.snake.getColumn(0) };
            case LEFT:
                return new int[] { this.snake.getRow(0), this.snake.getColumn(0) - 1 };
            case RIGHT:
                return new int[] { this.snake.getRow(0), this.snake.getColumn(0) + 1 };
            case UP:
                return new int[] { this.snake.getRow(0) - 1, this.snake.getColumn(0) };
            default:
                return null;
        }
    }

    public int predictRow() {
        // Utilise predictCoordinates(), but returns row as int instead.
        // First part of the int[] from predictCoordinates() is row, so 0 == row.
        return predictCoordinates()[0];
    }

    public int predictColumn() {
        // Utilise predictCoordinates(), but returns column as int instead.
        // Second part of the int[] from predictCoordinates() is column, so 1 == column.
        return predictCoordinates()[1];
    }

    public GameObject predictMovement() {
        // Utilise predictRow & predictColumn, but returns a GameObject instead.
        return this.grid[predictRow()][predictColumn()];
    }

    public double getCurrentGameScore() {
        return currentGameScore;
    }

    public String toStringScore() {
        return String.valueOf(this.currentGameScore);
    }

    public GameObject[][] getState() {
        return this.grid;
    }

    public Snake getSnake() {
        return this.snake;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public Layout getLayout() {
        return this.layout;
    }
}
