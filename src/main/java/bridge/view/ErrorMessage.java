package bridge.view;

public enum ErrorMessage {

    INCORRECT_MOVING("U 또는 D로만 이동할 수 있습니다.");

    private static final String prefix = "[Error] ";
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return prefix + message;
    }
}
