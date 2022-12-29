package GameLogic.GameObjects;
import javafx.scene.paint.Color;

public abstract class GameObject {
    private Color color;

    public GameObject(int red, int green, int blue) {
        this.color = Color.rgb(red, green, blue);
    }

    public Color getColor() {
        return this.color;
    }

}
