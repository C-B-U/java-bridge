package bridge;

public enum GameCommand {

    UP_BRIDGE("U"),
    DOWN_BRIDGE("D"),
    RETRY("R"),
    QUIT("Q");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
