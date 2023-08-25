package bridge;

public enum GameResult {


    GAME_SUCCESS("성공"),
    GAME_FAILED("실패");

    private final String message;

    GameResult(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public static String gameResult(){
        if (BridgeStageRecord.isClearsGame()){
            return GAME_SUCCESS.message;
        }
        return GAME_FAILED.message;
    }
}
