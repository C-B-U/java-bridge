package bridge;

public enum ErrorMessage {
    NOT_NUMERIC_INPUT("숫자만 입력 가능합니다."),
    BLANK_INPUT("입력값이 비어있습니다."),
    INVALID_CLASSIFIER("다리의 숫자 값이 올바르지 않습니다.");
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
