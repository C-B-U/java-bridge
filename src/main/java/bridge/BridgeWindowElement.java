package bridge;

public enum BridgeWindowElement {
    START("[ "),
    SUCCESS("O"),
    FAIL("X"),
    DIVISION(" | "),
    BLANK(" "),
    END(" ]");

    private final String value;

    BridgeWindowElement(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static BridgeWindowElement getStageWindowElement(boolean canMoveStage) {
        if (canMoveStage){
            return SUCCESS;
        }
        return FAIL;
    }

}
