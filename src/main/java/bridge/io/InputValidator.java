package bridge.io;

import bridge.constant.BridgeType;
import bridge.constant.ErrorMessage;
import bridge.constant.RetryCommand;

public class InputValidator {
    private static final Character START_NUMBER = '0';
    private static final Character END_NUMBER = '9';

    public void validateBridgeSizeInput(final String input) {
        validateNumeric(input);
        validateNotBlank(input);
    }

    private void validateNumeric(final String input) {
        if (hasNonNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_INPUT.toString());
        }
    }

    private boolean hasNonNumber(final String input) {
        return !input.chars().allMatch(this::isNumber);
    }

    private boolean isNumber(int character) {
        return START_NUMBER <= character && character <= END_NUMBER;
    }

    private void validateNotBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.toString());
        }
    }

    public void validateMovingInput(final String input) {
        validateNotBlank(input);
        validateMoveDirection(input);
    }

    private void validateMoveDirection(final String input) {
        if (!input.equals(BridgeType.U.toString()) && !input.equals(BridgeType.D.toString())) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_MOVE_DIRECTION.toString(), BridgeType.U, BridgeType.D));
        }
    }

    public void validateGameCommandInput(final String input) {
        if (!input.equals(RetryCommand.R.toString()) && !input.equals(RetryCommand.Q.toString())) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_RETRY_COMMAND.toString(), RetryCommand.R, RetryCommand.Q));
        }
    }
}
