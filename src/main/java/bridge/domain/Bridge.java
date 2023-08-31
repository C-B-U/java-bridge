package bridge.domain;

import bridge.constant.*;

import java.util.Collections;
import java.util.List;

public final class Bridge {
    private static final int NO_LEFT_ELEMENT = 0;
    private static final int INITIAL_INDEX = 0;
    private final List<String> directions;
    private int currentIndex;

    public Bridge(final List<String> directions) {
        final int size = directions.size();
        if (size < BridgeSize.MIN_BRIDGE_SIZE.size() || size > BridgeSize.MAX_BRIDGE_SIZE.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.toString());
        }
        this.directions = Collections.unmodifiableList(directions);
        this.currentIndex = INITIAL_INDEX;
    }

    public BridgeType getCurrentElement() {
        validateIndex(currentIndex);
        return BridgeType.valueOf(directions.get(currentIndex++));
    }

    private void validateIndex(final int currentIndex) {
        if (directions.size() <= currentIndex) {
            throw new IllegalArgumentException(ErrorMessage.NO_ELEMENT_LEFT.toString());
        }
    }

    private boolean hasNoRemainElement() {
        return directions.size() - currentIndex == NO_LEFT_ELEMENT;
    }

    public ResultStatus compareToInput(final BridgeType input, final BridgeType answer) {
        if (hasNoRemainElement()) {
            return checkSuccess(input, answer);
        }
        return checkContinue(input, answer);
    }

    private ResultStatus checkContinue(final BridgeType input, final BridgeType answer) {
        if (input == answer) {
            return ResultStatus.CONTINUE;
        }
        return ResultStatus.X;
    }

    private ResultStatus checkSuccess(final BridgeType input, final BridgeType answer) {
        if (input == answer) {
            return ResultStatus.O;
        }
        return ResultStatus.X;
    }
}
