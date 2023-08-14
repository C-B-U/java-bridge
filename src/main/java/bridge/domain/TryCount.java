package bridge.domain;

public final class TryCount {
    private static final int INITIAL_COUNT = 1;
    private static final int PLUS_UNIT = 1;
    private final int count;

    private TryCount(final int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.valueOf(this.count);
    }

    public static TryCount create() {
        return new TryCount(INITIAL_COUNT);
    }

    public TryCount next() {
        return new TryCount(this.count + PLUS_UNIT);
    }
}
