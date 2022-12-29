package GameLogic.GameObjects;
public class EmptyGameObject extends GameObject {

    private final static int RED = 0;
    private final static int GREEN = 0;
    private final static int BLUE = 255;

    public EmptyGameObject() {
        super(RED, GREEN, BLUE);
    }
}
