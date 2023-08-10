package bridge.view;

public enum OutputMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}