package bridge.domain;

public class TryCount {
    private static final int INITIAL_COUNT = 1;
    private Integer count;

    public TryCount() {
        this.count = INITIAL_COUNT;
    }

    public void nextCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return Integer.toString(count);
    }
}
