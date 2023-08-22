package bridge.domain;

import bridge.constant.GameClearMessage;
import bridge.constant.GameStatus;
import bridge.constant.RetryCommand;

public class GameRecorder {

    private static final int DEFAULT_POSITION = 0;
    private final BridgeSize bridgeSize;

    private int position;
    private GameStatus gameStatus;

    public GameRecorder(BridgeSize bridgeSize) {
        this.bridgeSize = bridgeSize;
        this.gameStatus = GameStatus.PROGRESS;
        this.position = DEFAULT_POSITION;
    }

    public void movePosition() {
        position++;
    }

    public void checkProgress(boolean canMoving) {
        gameStatus = GameStatus.checkStatus(canMoving, bridgeSize, position);
    }

    public void checkGameStatus(RetryCommand restartCommand) {
        gameStatus = GameStatus.checkStatus(restartCommand);
        if (gameStatus == GameStatus.RESTART) {
            initGame();
        }
    }

    private void initGame() {
        position = DEFAULT_POSITION;
        gameStatus = GameStatus.init();
    }

    public int getPosition() {
        return position;
    }

    public boolean isProgress() {
        return gameStatus.isProgress();
    }

    public boolean isNotEnd() {
        return gameStatus.isNotEnd();
    }

    public boolean isFailed() {
        return gameStatus.isFailed();
    }

    public String getGameClearMessage() {
        return GameClearMessage.getGameClearMessage(gameStatus.isClear());
    }
}