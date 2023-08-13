package bridge.model;

public class BridgeComparison {

    private final Bridge bridge;

    public BridgeComparison(Bridge bridge) {
        this.bridge = bridge;
    }

    public boolean checkMoving(String moving, int position) {
        String correctMoving = bridge.getBridgeByPosition(position);
        return correctMoving.equals(moving);
    }
}
