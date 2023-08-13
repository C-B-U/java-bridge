package bridge.view;

public enum BridgeElement {
    BRIDGE_START("[ "),
    BRIDGE_END(" ]"),
    BRIDGE_DELIMITER(" | ");


    private final String element;

    BridgeElement(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element;
    }
}
