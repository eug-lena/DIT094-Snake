package GameLogic.GameObjects;

public class SnakeSegment extends GameObject {

    private final static int BODY_RED = 0;
    private final static int BODY_GREEN = 0;
    private final static int BODY_BLUE = 0;

    private final static int HEAD_RED = 255;
    private final static int HEAD_GREEN = 255;
    private final static int HEAD_BLUE = 255;

    public SnakeSegment() {
        super(BODY_RED, BODY_GREEN, BODY_BLUE);
    }

    public SnakeSegment(boolean isHead) {
        super(HEAD_RED, HEAD_GREEN, HEAD_BLUE);
    }
    
    // Overloaded method so we can have different color for the head but still be a SnakeSegment. 
    // If constructor is given a boolean argument create with head color instead.

}
