package bridge;

public enum SuccessFailure {
    SUCCESS("성공"),
    FAILURE("실패");

    private final String result;

    SuccessFailure(String result) {
        this.result = result;
    }

    public String equals(boolean success) {
        if (success) {
            return SUCCESS.result;
        }
        return FAILURE.result;
    }
}