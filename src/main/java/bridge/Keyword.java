package bridge;

public enum Keyword {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    FINISH("Q");

    private final String key;

    Keyword(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}