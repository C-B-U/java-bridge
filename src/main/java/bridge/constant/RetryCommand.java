package bridge.constant;

import java.util.Arrays;
import java.util.Objects;

public enum RetryCommand {

    RETRY("R"),
    QUIT("Q");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    public static RetryCommand getCommand(String command) {
        return Arrays.stream(RetryCommand.values())
                .filter(value -> value.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INCORRECT_RETRY.toString()));
    }

    public boolean isRetry() {
        return Objects.equals(this.command, RETRY.command);
    }

    public boolean isQuit() {
        return Objects.equals(this.command, QUIT.command);
    }
    @Override
    public String toString() {
        return this.command;
    }
}
