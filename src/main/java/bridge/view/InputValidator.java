package bridge.view;

import bridge.model.Constant;

public class InputValidator {

    public void validateMoving(String input) {
        validateIsMovingInput(input);
    }

    private void validateIsMovingInput(String input) {
        if (!(input.equals(Constant.LOWER_CHAR.toString()) || input.equals(Constant.UPPER_CHAR.toString()))) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_MOVING.toString());
        }
    }

    public void validateRetry(String input) {
        validateIsRetryInput(input);
    }

    private void validateIsRetryInput(String input) {
        if (!(input.equals(Constant.RETRY.toString()) || input.equals(Constant.QUIT.toString()))) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_RETRY.toString());
        }
    }
}
