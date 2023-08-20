package bridge.manager;

import bridge.BridgeGame;
import bridge.constant.MoveResult;
import bridge.io.OutputView;
import bridge.io.InputManager;

public class BridgeGameManager {
    private final InputManager inputManager;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameManager(final InputManager inputManager, final OutputView outputView, final BridgeGame bridgeGame) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void playGame() {
        outputView.printGameStart();
        play();
    }

    private void play() {
        makeBridge();
        boolean isRunning = true;
        while (isRunning) {
            isRunning = moveAndCheckRetry();
        }
        outputView.printResult();
    }

    private boolean moveAndCheckRetry() {
        while (true) {
            final MoveResult moveResult = tryMove();
            if (moveResult.isNotContinue()) {
                return getRetryStatus(moveResult);
            }
            outputView.printMap();
        }
    }

    private boolean getRetryStatus(final MoveResult moveResult) {
        if (moveResult.isSuccess()) {
            return false;
        }
        outputView.printMap();
        return checkRetry();
    }

    private boolean checkRetry() {
        outputView.printRetryRequest();
        return false;
    }

    private MoveResult tryMove() {
        outputView.printMovingRequest();
        return null;
    }

    private void makeBridge() {
        outputView.printBridgeSizeRequest();
        final int bridgeSize = inputManager.bridgeSize();
        bridgeGame.makeBridge(bridgeSize);
    }
}
