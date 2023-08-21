package bridge.domain;

import bridge.constant.BridgeDirection;
import bridge.constant.MovingResult;
import bridge.constant.RetryCommand;

import java.util.ArrayList;
import java.util.List;

public class BridgeMaps {

    private final static String BLANK = " ";

    private final List<String> upper = new ArrayList<>();
    private final List<String> lower = new ArrayList<>();

    public void addResult(String userInput, boolean isSuccess) {
        setUpper(userInput, isSuccess);
        setLower(userInput, isSuccess);
    }

    private void setUpper(String userInput, boolean isSuccess) {
        if(userInput.equals(BridgeDirection.UP.getDirection())) {
            MovingResult correctMessage = MovingResult.calculateDisplay(isSuccess);
            System.out.println(correctMessage);
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

    public void clear(String command) {
        if (command.equals(RetryCommand.RETRY.toString())){
            upper.clear();
            lower.clear();
        }
    }
}