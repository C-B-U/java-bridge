package bridge.io;

import bridge.constant.BridgeType;
import bridge.constant.ErrorMessage;
import bridge.constant.RetryCommand;

public class InputValidator {
    private static final Character START_NUMBER = '0';
    private static final Character END_NUMBER = '9';
    public void validateBridgeSize(final String input) {
        validateNumeric(input);
    }

    private void validateNumeric(final String input) {
        if (hasNonNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_INPUT.toString());
        }
    }

    private boolean hasNonNumber(final String input) {
        return !input.chars().allMatch(this::isNumber);
    }

    private boolean isNumber(final int character) {
        return START_NUMBER <= character && character <= END_NUMBER;
    }

    public void validateMoving(final String input) {
        if (BridgeType.isNotMoveCommand(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVE_COMMAND.toString());
        }
    }

    public void validateRetryCommand(final String input) {
        if (RetryCommand.isNotRetryCommand(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RETRY_COMMAND.toString());
        }
    }
}
