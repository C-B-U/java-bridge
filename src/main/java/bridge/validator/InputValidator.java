package bridge.validator;

import bridge.constant.BridgeDirection;
import bridge.constant.ExceptionMessage;

public class InputValidator {

    public void validateMoving(String input) {
        if (BridgeDirection.isNotDirectionCommand(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INCORRECT_MOVING.toString());
        }
    }
}
