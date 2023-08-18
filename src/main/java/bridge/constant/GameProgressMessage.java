package bridge.constant;

public enum GameProgressMessage {

    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_MOVE_STAIR("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"),
    INPUT_RETRY_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)"),
    BLANK(" ");

    private final String message;

    GameProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String getMessage() {
        return message;
    }
}
