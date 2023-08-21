package bridge.constant;

public enum RetryCommand {

    RETRY("R"),
    QUIT("Q");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return this.command;
    }
}
