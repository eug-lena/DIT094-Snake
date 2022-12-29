package GameLogic;

import javafx.scene.input.KeyCode;

public enum Keybind {
    UP(KeyCode.W),
    DOWN(KeyCode.S),
    LEFT(KeyCode.A),
    RIGHT(KeyCode.D),
    PAUSE(KeyCode.SPACE);

    private KeyCode keyCode;

    Keybind(KeyCode keyCode) {
        this.keyCode = keyCode;
    }

    public KeyCode getKeyCode() {
        return this.keyCode;
    }

    public void setKeyCode(KeyCode newKeybind) {
        this.keyCode = newKeybind;
    }

    public static Keybind fromKeypress(KeyCode input) {
        for (Keybind keybind : Keybind.values()) {
            if (keybind.getKeyCode().equals(input)) {
                return keybind;
            }
        }
        return null;
    }
    // Used to see if a key that has been pressed should have an action.
    // If the pressed key is not supposed to have an action it returns null.
}
