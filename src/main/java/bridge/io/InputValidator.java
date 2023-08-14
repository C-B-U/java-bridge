package bridge.io;

import bridge.constant.ErrorMessage;

public class InputValidator {
    private static final Character START_NUMBER = '0';
    private static final Character END_NUMBER = '9';
    private static final Integer COMMAND_LENGTH = 1;

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

    public void validateCommand(final String input) {
        validateNotBlank(input);
        validateCommandLength(input);
    }

    private void validateCommandLength(final String input) {
        if (input.length() != COMMAND_LENGTH) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_COMMAND_LENGTH.toString(), COMMAND_LENGTH));
        }
    }
}
