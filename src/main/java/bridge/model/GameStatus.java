package bridge.model;

public class GameStatus {

    private int position;
    private int retry;
    private static final int START_POSITION = 0;
    private static final int INIT_RETRY_COUNT = 1;

    public GameStatus() {
        this.position = START_POSITION;
        this.retry = INIT_RETRY_COUNT;
    }

    public void movePosition() {
        position++;
    }

    public void increaseRetryCount() {
        retry++;
    }

    public int getRetry() {
        return retry;
    }

    public int getPosition() {
        return position;
    }

    public void clear() {
        position = START_POSITION;
    }
}
