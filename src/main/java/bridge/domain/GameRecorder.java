package bridge.domain;

import bridge.constant.GameStatus;

public class GameRecorder {

    private final int bridgeSize;

    private int position = 0;
    private int retryCount = 0;
    private GameStatus gameStatus;


    public GameRecorder(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        this.gameStatus = GameStatus.PROGRESS;
    }

    public void movePosition() {
        position++;
    }

    public void checkProgress(boolean canMoving) {
        gameStatus = GameStatus.checkProgress(canMoving, bridgeSize, position);
    }

    public int getPosition() {
        return position;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
