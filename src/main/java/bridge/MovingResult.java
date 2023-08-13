package bridge;

public class MovingResult {
    private final String direction;
    private final boolean answer;

    public MovingResult(String direction, boolean answer) {
        this.direction = direction;
        this.answer = answer;
    }

    public String getDirection() {
        return this.direction;
    }

    public boolean getAnswer() {
        return this.answer;
    }
}
