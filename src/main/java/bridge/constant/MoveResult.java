package bridge.constant;

public enum MoveResult {
    CONTINUE, FAILED, SUCCESS;

    public boolean isNotContinue() {
        return this != CONTINUE;
    }

    public boolean isSuccess() {
        return this == SUCCESS;
    }
}
