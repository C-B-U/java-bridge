package bridge.model;

public enum MovingResult {

    MOVING_SUCCESS("O", true),
    MOVING_FAILED("X", false);

    private final String answer;
    private final boolean success;

    MovingResult(String answer, boolean success) {
        this.answer = answer;
        this.success = success;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean getSuccess() {
        return success;
    }
}
