package bridge.domain;

import bridge.constant.BridgeSize;
import bridge.constant.BridgeType;
import bridge.constant.ErrorMessage;

import java.util.Collections;
import java.util.List;

public final class Bridge {
    private final List<String> directions;

    public Bridge(final List<String> directions) {
        final int size = directions.size();
        if (size < BridgeSize.MIN_BRIDGE_SIZE.size() || size > BridgeSize.MAX_BRIDGE_SIZE.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE.toString());
        }
        this.directions = Collections.unmodifiableList(directions);
    }

    public BridgeType getNextElement(final int currentIndex) {
        validateIndex(currentIndex);
        return BridgeType.valueOf(directions.get(currentIndex));
    }

    private void validateIndex(final int currentIndex) {
        if (directions.size() <= currentIndex) {
            throw new IllegalArgumentException(ErrorMessage.NO_ELEMENT_LEFT.toString());
        }
    }

    public int getRemainSize(final int currentIndex) {
        return directions.size() - currentIndex;
    }
}
