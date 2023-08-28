package bridge.domain;

public class AttemptCount {
    private int count = 1;

    public void increaseCount() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
