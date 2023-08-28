package bridge;

public enum MapElement {
    BLANK(" "),
    SUCCESS("O"),
    FAILURE("X"),
    OPEN_BRACKET("[ "),
    CLOSE_BRACKET(" ]"),
    DELIMITER(" | "),
    NEW_LINE("\n");

    private final String element;

    MapElement(String element) {
        this.element = element;
    }

    public String get() {
        return element;
    }
}
