package bridge;

public enum Keyword {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private static final int isUp = 1;
    private final String key;

    Keyword(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public static String toString(int generated) {
        if(generated == isUp) {
            return UP.getKey();
        }
        return DOWN.getKey();
    }
}