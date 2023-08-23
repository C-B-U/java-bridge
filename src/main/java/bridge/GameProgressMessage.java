package bridge;

public enum GameProgressMessage {

    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요.");
    
    private final String message;

    GameProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
