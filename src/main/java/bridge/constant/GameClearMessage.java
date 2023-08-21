package bridge.constant;

public enum GameClearMessage {

    GAME_CLEAR("성공"),
    GAME_FAILED("실패");

    private final String message;

    GameClearMessage(String message) {
        this.message = message;
    }

    public static String getGameClearMessage(boolean isClear) {
        if(isClear) {
            return GAME_CLEAR.message;
        }
        return GAME_FAILED.message;
    }
}
