package bridge.constant;

import java.util.Arrays;

public enum MovingResult {

    MOVING_SUCCESS("O", true),
    MOVING_FAILED("X", false);

    private final String display;
    private final boolean success;

    MovingResult(String display, boolean success) {
        this.display = display;
        this.success = success;
    }

    public static MovingResult calculateDisplay(boolean isSuccess) {
        return Arrays.stream(MovingResult.values())
                .filter(movingResult -> movingResult.success == isSuccess)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.MOVING_RESULT_NONE.toString()));
    }

    public String getDisplay() {
        return this.display;
    }
}
