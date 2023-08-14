package bridge.constant;

import java.util.Arrays;

public enum BridgeType {
    U(1),
    D(0);

    private final Integer classifier;

    BridgeType(final Integer classifier) {
        this.classifier = classifier;
    }

    public static String getDirectionByClassifier(final int classifier) {
        return Arrays.stream(BridgeType.values())
                .filter(bridgeType -> bridgeType.classifier.equals(classifier))
                .findAny()
                .map(Enum::toString)
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_CLASSIFIER.toString()));
    }
}
