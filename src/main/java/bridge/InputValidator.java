package bridge;

import static bridge.ErrorMessage.*;
import static bridge.Keyword.*;

public class InputValidator {

    private static final String numberRegex = "[1-9]\\d*";

    public void validateBridgeSize(String bridgeSize) {
        validateIsDigit(bridgeSize);
        validateIsRange(bridgeSize);
    }

    private void validateIsDigit(String bridgeSize) {
        if (!bridgeSize.matches(numberRegex)) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_MUST_BE_DIGIT.getMessage());
        }
    }

    private void validateIsRange(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_MUST_BE_3_TO_20.getMessage());
        }
    }

    public void validateMoving(String selectedBridge) {
        if (!selectedBridge.equals(UP.getKey()) && !selectedBridge.equals(DOWN.getKey())) {
            throw new IllegalArgumentException(INPUT_MUST_HAS_U_OR_D.getMessage());
        }
    }

    public void validateGameCommand(String gameOrNot) {
        if (!gameOrNot.equals(RETRY.getKey()) && !gameOrNot.equals(FINISH.getKey())) {
            throw new IllegalArgumentException(RETRY_COMMAND_MUST_HAS_R_OR_Q.getMessage());
        }
    }
}
