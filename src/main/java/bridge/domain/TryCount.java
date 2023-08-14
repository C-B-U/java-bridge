package bridge.domain;

public class TryCount {
    private static final int INITIAL_COUNT = 1;
    private int count;

    public TryCount() {
        this.count = INITIAL_COUNT;
    }

    @Override
    public String toString() {
        return String.valueOf(this.count);
    }

    public void increment() {
        this.count++;
    }
}
