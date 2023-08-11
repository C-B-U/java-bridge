package bridge.model;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean checkMoving(String moving, int position) {
        String correctMoving = bridge.get(position);
        return correctMoving.equals(moving);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
