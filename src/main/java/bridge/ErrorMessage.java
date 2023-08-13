package bridge;

public enum ErrorMessage {
    BRIDGE_LENGTH_MUST_BE_DIGIT("다리 길이는 숫자만 입력 가능합니다."),
    BRIDGE_LENGTH_MUST_BE_3_TO_20("다리 길이는 3 이상 20 이하의 숫자만 입력 가능합니다"),
    INPUT_MUST_HAS_U_OR_D("다리를 건너기 위해서는 U 또는 D를 입력해야 합니다."),
    RETRY_COMMAND_MUST_HAS_R_OR_Q("게임 재시작하거나 종료하기 위해서는 R 또는 Q를 입력해야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
