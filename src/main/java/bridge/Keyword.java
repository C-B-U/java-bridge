package bridge;

public enum Keyword {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private final String key;

    Keyword(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public static String equalsKey(int generate) {
        if (generate == 1) {
            return UP.getKey();
        }
        return DOWN.getKey();
    }
}