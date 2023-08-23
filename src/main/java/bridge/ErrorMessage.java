package bridge;

public enum ErrorMessage {

    // bridge
    BRIDGE_LENGTH_ERROR("다리 길이는 %s~%s 사이의 숫자입니다."),
    BRIDGE_STAGE_COMMAND_ERROR("이동할 칸은 %s 혹은 %s 입니다."),

    // global
    INPUT_NOT_NUMBER_ERROR("숫자가 아닙니다."),
    INPUT_NOT_UPPER_ENGLISH_ERROR("대문자 영어가 아닙니다.");


    private static final String error = "[ERROR] ";
    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return error + message;
    }
}
