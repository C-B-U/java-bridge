package bridge.domain;

public class TryCount {
    private Integer count;

    public TryCount() {
        this.count = 1;
    }

    public void nextCount() {
        this.count++;
    }

    @Override
    public String toString() {
        return Integer.toString(count);
    }
}
