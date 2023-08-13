package bridge;

public class InputValidator {

    public void validateBridgeLengthInput(final String input) {
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
        return '0' <= character && character <= '9';
    }

    private void validateNotBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.toString());
        }
    }
}
