package bridge.view;

public enum ExceptionMessage {

    INCORRECT_MOVING("U 또는 D로만 이동할 수 있습니다."),
    INCORRECT_RETRY("R 또는 Q만 입력할 수 있습니다."),
    NOT_INTEGER("숫자만 입력할 수 있습니다."),
    INCORRECT_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private static final String prefix = "[Error] ";
    private final String message;
    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return prefix + message;
    }
}
