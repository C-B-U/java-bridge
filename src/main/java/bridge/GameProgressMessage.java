package bridge;

public enum GameProgressMessage {

    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_BRIDGE_STAGE("이동할 칸을 선택해주세요. (위: %s, 아래: %s)");

    private final String message;

    GameProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
