package bridge;

public class InputValidator {
    private static final String NUMERIC_MATCHER = "[0-9]+";

    public void validateBridgeLengthInput(final String input) {
        if (isBlankInput(input) || isNotNumeric(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotNumeric(final String input) {
        return !input.matches(NUMERIC_MATCHER);
    }

    private boolean isBlankInput(final String input) {
        return input.isBlank();
    }
}
