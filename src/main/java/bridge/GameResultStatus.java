package bridge;

public enum GameResultStatus {
    O, X, NONE;

    private static final String BLANK = " ";

    @Override
    public String toString() {
        if (this == NONE) {
            return BLANK;
        }
        return this.name();
    }
}
