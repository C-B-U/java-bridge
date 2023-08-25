package bridge;

public enum BridgeMapElement {
    START("[ "),
    SUCCESS("O"),
    FAIL("X"),
    DIVISION(" | "),
    BLANK(" "),
    END(" ]");

    private final String value;

    BridgeMapElement(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static BridgeMapElement getStageWindowElement(boolean canMoveStage) {
        if (canMoveStage){
            return SUCCESS;
        }
        return FAIL;
    }

}
