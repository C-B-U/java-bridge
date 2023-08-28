package bridge;

public enum ExceptionMessage {
    BRIDGE_SIZE_EXCEPTION("다리 길이는 3이상 20이하의 숫자만 가능합니다. 다시 입력해 주십시오."),
    MOVING_INPUT_EXCEPTION("이동할 칸은 U 또는 D만 입력 가능합니다. 다시 입력해 주십시오."),
    RETRY_OR_QUIT_EXCEPTION("재시작 여부는 R 또는 Q만 입력 가능합니다. 다시 입력해 주십시오.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}