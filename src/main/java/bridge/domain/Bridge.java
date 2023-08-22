package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
    }

    public boolean isCorrectMoving(String moving, int position) {
        String correctMoving = bridge.get(position);
        return correctMoving.equals(moving);
    }
}
