package bridge.constant;

import bridge.domain.BridgeSize;

public enum GameStatus {

    PROGRESS,
    MOVING_FAILED,
    GAME_SUCCESS,
    RESTART,
    GAME_QUIT;

    public static GameStatus checkStatus(RetryCommand command) {
        if (command.isQuit()){
            return GameStatus.GAME_QUIT;
        }
        return GameStatus.RESTART;
    }

    public static GameStatus checkStatus(boolean canMoving, BridgeSize bridgeSize, int position) {
        if (!canMoving) {
            return GameStatus.MOVING_FAILED;
        }
        return checkGameStatus(bridgeSize, position);
    }

    private static GameStatus checkGameStatus(BridgeSize bridgeSize, int position) {
        if (bridgeSize.isSame(position)) {
            return GameStatus.GAME_SUCCESS;
        }
        return GameStatus.PROGRESS;
    }

    public static GameStatus init() {
        return GameStatus.PROGRESS;
    }

    public boolean isProgress() {
        return this == PROGRESS;
    }

    public boolean isNotEnd() {
        return this != GAME_QUIT &&  this != GameStatus.GAME_SUCCESS;
    }

    public boolean isFailed() {
        return this == GameStatus.MOVING_FAILED;
    }

    public boolean isClear() {
        return this == GameStatus.GAME_SUCCESS;
    }
}
