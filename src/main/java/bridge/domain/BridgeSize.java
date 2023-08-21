package bridge.domain;

import bridge.constant.ExceptionMessage;

public class BridgeSize {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int bridgeSize;

    public BridgeSize(int bridgeSize) {
        validateIsCorrectRange(bridgeSize);
        this.bridgeSize = bridgeSize;
    }

    private void validateIsCorrectRange(int bridgeSize) {
        if (!(MIN_SIZE <= bridgeSize && bridgeSize <= MAX_SIZE)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_RANGE;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    public boolean isSame(int size) {
        return bridgeSize == size;
    }
}
