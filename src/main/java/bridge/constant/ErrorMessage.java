package bridge.constant;

public enum ErrorMessage {
    NOT_NUMERIC_INPUT("숫자만 입력 가능합니다."),
    BLANK_INPUT("입력값이 비어있습니다."),
    INVALID_MOVE_COMMAND(String.format("이동 방향 입력값은 %s 혹은 %s 입니다.", MoveCommand.D, MoveCommand.U));

    private final String message;
    private static final String ERROR_PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX + this.message;
    }
}
