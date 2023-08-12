package bridge.view;

import bridge.model.Constant;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_REGEXP = "^\\d*$";
    private static final int MAX_BRIDGE_LENGTH = 20;
    private static final int MIN_BRIDGE_LENGTH = 1;

    public void validateMoving(String input) {
        validateIsMovingInput(input);
    }

    private void validateIsMovingInput(String input) {
        if (!(input.equals(Constant.LOWER_CHAR.toString()) || input.equals(Constant.UPPER_CHAR.toString()))) {
            throw new IllegalArgumentException(ExceptionMessage.INCORRECT_MOVING.toString());
        }
    }

    public void validateRetry(String input) {
        validateIsRetryInput(input);
    }

    private void validateIsRetryInput(String input) {
        if (!(input.equals(Constant.RETRY.toString()) || input.equals(Constant.QUIT.toString()))) {
            throw new IllegalArgumentException(ExceptionMessage.INCORRECT_RETRY.toString());
        }
    }

    public void validateBridgeLength(String input) {
        validateIsNumber(input);
        validateIsCorrectRange(Integer.parseInt(input));
    }

    private void validateIsNumber(String input) {
        if (!Pattern.matches(NUMBER_REGEXP, input)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.NOT_INTEGER;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }

    private void validateIsCorrectRange(int input) {
        if (!(MIN_BRIDGE_LENGTH <= input && input <= MAX_BRIDGE_LENGTH)) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_RANGE;
            throw new IllegalArgumentException(exceptionMessage.toString());
        }
    }
}
