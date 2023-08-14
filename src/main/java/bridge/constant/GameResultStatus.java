package bridge.constant;

public enum GameResultStatus {
    O("O"),
    X("X"),
    NONE(" ");

    private final String symbol;

    GameResultStatus(final String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
