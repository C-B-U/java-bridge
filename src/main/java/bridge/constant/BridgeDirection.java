package bridge.constant;

import java.util.Arrays;

public enum BridgeDirection {

    DOWN(0, "D"),
    UP(1, "U");

    private final int generateValue;
    private final String direction;


    BridgeDirection(int generateValue, String message) {
        this.generateValue = generateValue;
        this.direction = message;
    }

    public static BridgeDirection convertDirection(int generateValue) {
        return Arrays.stream(BridgeDirection.values())
                .filter(value -> value.generateValue == generateValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_BRIDGE_ELEMENT.toString()));
    }

    public String getDirection() {
        return direction;
    }
}
