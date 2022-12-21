public enum Direction {
    UP(Keybind.UP),
    DOWN(Keybind.DOWN),
    LEFT(Keybind.LEFT),
    RIGHT(Keybind.RIGHT);

    private Keybind keybind;

    Direction(Keybind keybind) {
        this.keybind = keybind;
    }

    public Keybind getKeybind() {
        return this.keybind;
    }
}

