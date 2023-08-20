package bridge.constant;

public enum GameMessage {
    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_SIZE_REQUEST("다리의 길이를 입력해주세요."),
    MOVE_DIRECTION_REQUEST(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", BridgeType.U, BridgeType.D)),
    RETRY_REQUEST(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", RetryCommand.R, RetryCommand.Q));

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
