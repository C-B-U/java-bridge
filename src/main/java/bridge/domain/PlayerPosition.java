package bridge.domain;

public class PlayerPosition {
    private int position;

    public PlayerPosition() {
        position = -1;
    }

    public void moveNextPosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
