package bridge.constant;

public enum ExceptionMessage {

    NOT_BRIDGE_ELEMENT("다리 건너기 게임을 시작합니다."),
    MOVING_RESULT_NONE("해당 방향으로 움직일 수 없습니다."),
    INCORRECT_MOVING("U 또는 D로만 이동할 수 있습니다."),
    INCORRECT_RETRY("R 또는 Q만 입력할 수 있습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}