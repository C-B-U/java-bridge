package bridge;

public enum BridgeWindow {

    START("[ "),
    SUCCESS("0"),
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
