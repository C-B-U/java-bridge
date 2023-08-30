package bridge.constant;

public enum MoveCommand {
    U, D;

    public static boolean isNotMoveCommand(final String input) {
        return !input.equals(U.toString()) && !input.equals(D.toString());
    }
}
