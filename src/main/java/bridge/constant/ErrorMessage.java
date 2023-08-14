package bridge.constant;

public enum ErrorMessage {
    NOT_NUMERIC_INPUT("숫자만 입력 가능합니다."),
    BLANK_INPUT("입력값이 비어있습니다."),
    INVALID_CLASSIFIER("다리의 숫자 값이 올바르지 않습니다."),
    INVALID_MOVE_DIRECTION("이동 방향 입력값은 %s 혹은 %s 입니다."),
    NO_ELEMENT_LEFT("리스트의 원소가 없습니다."),
    INVALID_RETRY_COMMAND("재시도 여부 입력값은 %s 혹은 %s 입니다."),
    INVALID_BRIDGE_SIZE("다리의 길이는 %d 이상, %d 이하입니다.");

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
