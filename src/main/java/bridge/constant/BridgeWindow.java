package bridge.constant;

public enum BridgeWindow {

    START("[ "),
    SUCCESS("O"),
    FAIL("X"),
    DIVISION(" | "),
    BLANK(" "),
    END(" ]");

    private final String value;

    BridgeWindow(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
