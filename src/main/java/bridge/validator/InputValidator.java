package bridge.validator;

import bridge.ExceptionMessage;
import bridge.Keyword;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String regex = "^[0-9]+$";
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    public void validateBridgeSize(String size) {
        validateBridgeSizeIsNumber(size);
        validateBridgeSizeRange(size);
    }

    private void validateBridgeSizeIsNumber(String size) {
        if (!Pattern.matches(regex, size)) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateBridgeSizeRange(String size) {
        if (Integer.parseInt(size) < MINIMUM_BRIDGE_SIZE || Integer.parseInt(size) > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.BRIDGE_SIZE_EXCEPTION.getMessage());
        }
    }
}