package bridge.constant;

public enum GameMessage {
    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_SIZE_REQUEST("다리의 길이를 입력해주세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
