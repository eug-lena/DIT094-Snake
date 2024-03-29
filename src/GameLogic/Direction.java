package GameLogic;

public enum Direction {
    UP(Keybind.UP),
    DOWN(Keybind.DOWN),
    LEFT(Keybind.LEFT),
    RIGHT(Keybind.RIGHT);

    private Keybind keybind;
    // Each direction has a specified keybind, to be able to utilise setOnKeyPress()
    // for direction updates.

    Direction(Keybind keybind) {
        this.keybind = keybind;
    }

    public Keybind getKeybind() {
        return this.keybind;
    }

    public Direction getOppositeDirection() {
        switch (this) {
            case DOWN:
                return Direction.UP;
            case LEFT:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.LEFT;
            case UP:
                return Direction.DOWN;
            default:
                return null;
        }
    }
}
