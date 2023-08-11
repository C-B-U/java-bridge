package bridge.model;

public enum MovingResult {

    UPPER_SUCCESS("U", "O", true),
    UPPER_FAILED("U", "X", false),
    LOWER_SUCCESS("D", "O", true),
    LOWER_FAILED("D", "X", false);

    private final String input;
    private final String answer;
    private final boolean success;

    MovingResult(String input, String answer, boolean success) {
        this.input = input;
        this.answer = answer;
        this.success = success;
    }

    public String getInput() {
        return input;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean getSuccess() {
        return success;
    }
}
