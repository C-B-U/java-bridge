package bridge;

public enum GameMessage {
    START_GAME("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_SIZE_REQUEST("다리의 길이를 입력해주세요."),
    MOVE_DIRECTION_REQUEST("이동할 칸을 선택해주세요. (위: %s, 아래: %s)"),
    SUCCESS("게임 성공 여부: 성공\n총 시도한 횟수: %s"),
    RETRY_REQUEST("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)"),
    FINAL_RESULT("최종 게임 결과");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
