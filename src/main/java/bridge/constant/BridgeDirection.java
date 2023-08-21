package bridge.constant;

import java.util.Arrays;

public enum BridgeDirection {

    DOWN(0, "D"),
    UP(1, "U");

    private final int generateValue;
    private final String direction;


    BridgeDirection(int generateValue, String direction) {
        this.generateValue = generateValue;
        this.direction = direction;
    }

    public static BridgeDirection convertDirection(int generateValue) {
        return Arrays.stream(BridgeDirection.values())
                .filter(value -> value.generateValue == generateValue)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_BRIDGE_ELEMENT.toString()));
    }

    public static boolean isNotDirectionCommand(String direction) {
        return !(direction.equals(UP.direction) || direction.equals(DOWN.direction));
    }

    public String getDirection() {
        return direction;
    }
}
