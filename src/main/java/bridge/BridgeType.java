package bridge;

import java.util.Arrays;

public enum BridgeType {
    UPPER("U", 1),
    LOWER("D", 0);

    private final String symbol;
    private final Integer classifier;

    BridgeType(final String symbol, final Integer classifier) {
        this.symbol = symbol;
        this.classifier = classifier;
    }

    public static String getSymbolByClassifier(final int classifier) {
        return Arrays.stream(BridgeType.values())
                .filter(bridgeType -> bridgeType.classifier.equals(classifier))
                .findAny()
                .map(bridgeType -> bridgeType.symbol)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_CLASSIFIER.toString()));
    }
}
