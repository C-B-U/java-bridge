package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> directions;

    public Bridge(final List<String> directions) {
        this.directions = new ArrayList<>(directions);
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

    public int getLeftSize() {
        return directions.size();
    }
}
