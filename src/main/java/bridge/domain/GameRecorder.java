package bridge.domain;

import bridge.constant.GameStatus;

import java.util.Objects;

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

    public void updateRetry(String restartCommand) {
        if (gameStatus == GameStatus.MOVING_FAILED) {
            gameStatus = checkGameStatus(restartCommand);
        }
    }

    private GameStatus checkGameStatus(String restartCommand) {
        if (Objects.equals(restartCommand, "Q")){
            return GameStatus.GAME_QUIT;
        }
        initGame();
        return GameStatus.PROGRESS;
    }

    private void initGame() {
        position = 0;
        retryCount++;
    }

    public int getPosition() {
        return position;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
