package bridge.validator;

import bridge.constant.BridgeDirection;
import bridge.constant.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {

    public void validateMoving(String input) {
        if (BridgeDirection.isNotDirectionCommand(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INCORRECT_MOVING.toString());
        }
    }

    public void validateIsNumber(String input) {
        String NUMBER_REGEXP = "^\\d*$";
        if (!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
