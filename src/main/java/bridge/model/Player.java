package bridge.model;

public class Player {

    private int position;
    private static final int START_POSITION = 0;

    public Player() {
        this.position = START_POSITION;
    }

    public void movePosition() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public void clear() {
        position = START_POSITION;
    }
}
