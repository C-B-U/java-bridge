package bridge.constant;

public enum ResultStatus {
    O("O"),
    X("X"),
    NONE(" ");

    private final String symbol;

    ResultStatus(final String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
