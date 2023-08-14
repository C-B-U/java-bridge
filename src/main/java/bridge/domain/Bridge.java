package bridge.domain;

import bridge.constant.BridgeType;
import bridge.constant.ErrorMessage;

import java.util.Collections;
import java.util.List;

public final class Bridge {
    private final List<String> directions;

    private Bridge(final List<String> directions) {
        this.directions = Collections.unmodifiableList(directions);
    }

    public static Bridge create(final List<String> directions) {
        return new Bridge(directions);
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

    public int getLeftSize(final int currentIndex) {
        return directions.size() - currentIndex;
    }
}
