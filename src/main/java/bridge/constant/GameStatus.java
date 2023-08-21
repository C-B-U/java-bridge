package bridge.constant;

public enum GameStatus {

    PROGRESS,
    MOVING_FAILED,
    GAME_SUCCESS,
    GAME_QUIT;

    public static GameStatus checkProgress(boolean canMoving, int bridgeSize, int position) {
        if (!canMoving) {
            return GameStatus.MOVING_FAILED;
        }
        return checkGameStatus(bridgeSize, position);
    }

    private static GameStatus checkGameStatus(int bridgeSize, int position) {
        if (bridgeSize == position) {
            return GameStatus.GAME_SUCCESS;
        }
        return GameStatus.PROGRESS;
    }
}
