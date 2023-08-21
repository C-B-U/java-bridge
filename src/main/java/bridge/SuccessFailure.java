package bridge;

public enum SuccessFailure {
    SUCCESS("성공",true),
    FAILURE("실패",false);

    private final String result;
    private final boolean success;

    SuccessFailure(String result, boolean success) {
        this.result = result;
        this.success = success;
    }

    public String equals(boolean success) {
        if (this.success == success) {
            return SUCCESS.result;
        }
        return FAILURE.result;
    }
}