package bridge.constant;

import java.util.Objects;

public enum GameStatus {

    PROGRESS,
    MOVING_FAILED,
    GAME_SUCCESS,
    RESTART,
    GAME_QUIT;

    public static GameStatus checkStatus(String command) {
        if (Objects.equals(command, "Q")){
            return GameStatus.GAME_QUIT;
        }
        return GameStatus.RESTART;
    }

    public static GameStatus checkStatus(boolean canMoving, int bridgeSize, int position) {
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
}
