package bridge;

public enum MoveResult {
    KEEP_GOING, FAILED, SUCCESS;

    public boolean isContinue() {
        return this == KEEP_GOING;
    }
}
