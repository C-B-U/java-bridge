package bridge.constant;

public enum BridgeSize {
    MIN_BRIDGE_SIZE(3),
    MAX_BRIDGE_SIZE(20);
    private final int size;

    BridgeSize(int size) {
        this.size = size;
    }

    public int size() {
        return this.size;
    }
}
