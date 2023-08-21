package bridge.constant;

public enum ErrorMessage {
    NOT_RANGE("다리의 길이는 %d~%d 사이의 숫자입니다."),
    NOT_MOVE_STAGE("이동할 칸은 '%s' 혹은 '%s' 입니다."),
    NOT_RETRY_COMMAND("게임을 다시 시도할 명령어는 '%s' 혹은 '%s' 입니다."),
    NOT_NUMBER_STRING("숫자로된 문자열이 아닙니다."),
    NOT_UPPER_ENGLISH("대문자 영어가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR]" + message;
    }
}
