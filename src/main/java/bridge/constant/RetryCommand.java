package bridge.constant;

public enum RetryCommand {
    R, Q;

    public static boolean isNotRetryCommand(final String input) {
        return !input.equals(R.toString()) && !input.equals(Q.toString());
    }

    public boolean isRetry() {
        return this == R;
    }
}
