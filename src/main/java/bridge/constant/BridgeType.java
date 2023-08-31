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

    public static boolean isNotMoveCommand(final String input) {
        return !input.equals(U.toString()) && !input.equals(D.toString());
    }

    public boolean isUp() {
        return this == U;
    }
}
