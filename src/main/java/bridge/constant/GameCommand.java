package bridge.constant;

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

    public static String bridgeStageCase(int num){
        if (num == 0){
            return GameCommand.DOWN_BRIDGE.getCommand();
        }
        return GameCommand.UP_BRIDGE.getCommand();
    }

    @Override
    public String toString() {
        return command;
    }
}
