package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private final List<String> directions;

    public Bridge(final List<String> directions) {
        this.directions = new ArrayList<>(directions);
    }

    public BridgeType getFirstElement() {
        if (directions.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NO_ELEMENT_LEFT.toString());
        }
        return BridgeType.valueOf(directions.remove(FIRST_ELEMENT_INDEX));
    }

    public int getLeftSize() {
        return directions.size();
    }
}
