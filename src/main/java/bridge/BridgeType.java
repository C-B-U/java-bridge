package bridge;

public enum BridgeType {
    UPPER("U", 1),
    LOWER("D", 0);

    private final String symbol;
    private final Integer classifier;

    BridgeType(final String symbol, final Integer classifier) {
        this.symbol = symbol;
        this.classifier = classifier;
    }

    public Integer getClassifier() {
        return this.classifier;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
