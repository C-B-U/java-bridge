package bridge;

public enum BridgeGameMessage {
    START_GAME("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH_REQUEST("다리의 길이를 입력해주세요.")
    ;

    private final String message;

    BridgeGameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
