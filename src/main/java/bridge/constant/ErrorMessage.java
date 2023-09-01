package bridge.constant;

public enum ErrorMessage {
    NOT_NUMERIC_INPUT("숫자만 입력 가능합니다."),
    INVALID_MOVE_COMMAND(String.format("이동 방향 입력값은 %s 혹은 %s 입니다.", BridgeType.D, BridgeType.U)),
    INVALID_CLASSIFIER("다리의 숫자 값이 올바르지 않습니다."),
    INVALID_BRIDGE_SIZE(String.format("다리의 길이는 %d 이상, %d 이하입니다.", BridgeSize.MIN_BRIDGE_SIZE.size(), BridgeSize.MAX_BRIDGE_SIZE.size())),
    INVALID_RETRY_COMMAND(String.format("재시도 여부 입력값은 %s 혹은 %s 입니다.", RetryCommand.R, RetryCommand.Q)),
    NO_ELEMENT_LEFT("리스트의 원소가 없습니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX + this.message;
    }
}
