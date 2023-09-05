package bridge.constant;

public enum ResultStatus {
    O("O"),
    X("X"),
    CONTINUE("O"),
    NONE(" ");

    private final String symbol;

    ResultStatus(final String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public boolean isContinue() {
        return this == CONTINUE;
    }

    public boolean isSuccess() {
        return this == O;
    }

    public boolean isCorrect() {
        return isContinue() || isSuccess();
    }
}
