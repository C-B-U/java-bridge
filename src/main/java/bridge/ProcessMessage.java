package bridge;

public enum ProcessMessage {
    START_GAME_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    SELECT_MOVING_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_OR_END_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_GAME_MESSAGE("최종 게임 결과"),
    SUCCESS_OR_NOT_MESSAGE("게임 성공 여부: "),
    TOTAL_ATTEMPTS_MESSAGE("총 시도한 횟수: "),
    NEXT_LINE("\n");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}