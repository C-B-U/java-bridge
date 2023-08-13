package bridge;

public class InputValidator {
    private static final String NUMERIC_MATCHER = "[0-9]+";

    public void validateBridgeLengthInput(final String input) {
        validateNumeric(input);
        validateNotBlank(input);
    }

    private void validateNumeric(final String input) {
        if (!input.matches(NUMERIC_MATCHER)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_INPUT.toString());
        }
    }

    private void validateNotBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.toString());
        }
    }
}
