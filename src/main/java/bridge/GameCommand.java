package bridge;

public enum GameCommand {
    UP_STAIR("U"),
    DOWN_STAIR("D");


    private final static int  DOWN_RANDOM_NUMBER = 0;
    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return command;
    }

    public static String bridgeStageCase(int num){
        if (num == DOWN_RANDOM_NUMBER){
            return DOWN_STAIR.getCommand();
        }
        return UP_STAIR.getCommand();
    }

    public static boolean isNotBridgeStageCommand(String bridgeStage) {
        return !bridgeStage.equals(UP_STAIR.getCommand()) && !bridgeStage.equals(DOWN_STAIR.getCommand());
    }

    public static boolean isBridgeStageCommandU(String bridgeStage){
        return bridgeStage.equals(UP_STAIR.getCommand());
    }
}
