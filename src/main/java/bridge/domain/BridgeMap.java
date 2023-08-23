package bridge.domain;

import bridge.Keyword;
import bridge.MapElement;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    private final List<String> upperBridgeMap;
    private final List<String> lowerBridgeMap;

    public BridgeMap() {
        upperBridgeMap = new ArrayList<>();
        lowerBridgeMap = new ArrayList<>();
    }

    public void addMovingResult(String moving, boolean result) {
        String element = isSuccessMoving(result);
        if (isUpPosition(moving)) {
            upperBridgeMap.add(element);
            lowerBridgeMap.add(MapElement.BLANK.get());
            return;
        }
        upperBridgeMap.add(MapElement.BLANK.get());
        lowerBridgeMap.add(element);
    }

    private String isSuccessMoving(boolean result) {
        if (result) {
            return MapElement.SUCCESS.get();
        }
        return MapElement.FAILURE.get();
    }

    public boolean isUpPosition(String moving) {
        return moving.equals(Keyword.UP.getKey());
    }

    public String drawBridgeMap() {
        return joinBridgeMap(upperBridgeMap) + MapElement.NEW_LINE.get() + joinBridgeMap(lowerBridgeMap);
    }

    private String joinBridgeMap(List< String> bridgeMap) {
        return MapElement.OPEN_BRACKET.get()
                + String.join(MapElement.DELIMITER.get(), bridgeMap)
                + MapElement.CLOSE_BRACKET.get();
    }
}
