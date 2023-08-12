package bridge.view;

public enum OutputMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    LENGTH_MESSAGE("다리의 길이를 입력해주세요."),
    MOVE_LOCATION("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_END_MESSAGE("최종 게임 결과"),
    GAME_STATUS("게임 성공 여부: %s\n"),
    RETRY_NUMBERS("총 시도한 횟수: %d\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}