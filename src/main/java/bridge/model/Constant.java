package bridge.model;

public enum Constant {

    UPPER_CHAR("U"),
    LOWER_CHAR("D");

    private final String constant;

    Constant(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return constant;
    }
}
