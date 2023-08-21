package bridge.constant;

public enum ExceptionMessage {

    NOT_BRIDGE_ELEMENT("다리 건너기 게임을 시작합니다.");

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