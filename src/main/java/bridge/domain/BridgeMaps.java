package bridge.domain;

import bridge.constant.BridgeDirection;
import bridge.constant.BridgeElement;
import bridge.constant.MovingResult;
import bridge.constant.RetryCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BridgeMaps {

    private static final String BLANK = " ";

    private final List<String> upper = new ArrayList<>();
    private final List<String> lower = new ArrayList<>();

    public void addResult(String userInput, boolean isSuccess) {
        setUpper(userInput, isSuccess);
        setLower(userInput, isSuccess);
    }

    private void setUpper(String userInput, boolean isSuccess) {
        if(userInput.equals(BridgeDirection.UP.getDirection())) {
            MovingResult correctMessage = MovingResult.calculateDisplay(isSuccess);
            upper.add(correctMessage.getDisplay());
            lower.add(BLANK);
        }
    }

    private void setLower(String userInput, boolean success) {
        if(userInput.equals(BridgeDirection.DOWN.getDirection())) {
            MovingResult resultMessage = MovingResult.calculateDisplay(success);
            lower.add(resultMessage.getDisplay());
            upper.add(BLANK);
        }
    }

    public void clear(RetryCommand command) {
        if (command.isRetry()){
            upper.clear();
            lower.clear();
        }
    }

    @Override
    public String toString() {
        return setBridge(upper) + "\n" + setBridge(lower);
    }

    private String setBridge(List<String> bridge) {
        StringJoiner stringJoiner = new StringJoiner(BridgeElement.BRIDGE_DELIMITER.toString(), BridgeElement.BRIDGE_START.toString(), BridgeElement.BRIDGE_END.toString());
        bridge.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }
}