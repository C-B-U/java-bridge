package bridge.manager;

import bridge.BridgeGame;
import bridge.constant.BridgeType;
import bridge.constant.ResultStatus;
import bridge.constant.RetryCommand;
import bridge.io.OutputView;
import bridge.io.InputProvider;

public class BridgeGameManager {
    private final InputProvider inputProvider;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameManager(final InputProvider inputProvider, final OutputView outputView, final BridgeGame bridgeGame) {
        this.inputProvider = inputProvider;
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
            if (isRunning) {
                bridgeGame.retry();
            }
        }
        outputView.printResult(bridgeGame.findGameResult());
    }

    private boolean moveAndCheckRetry() {
        while (true) {
            final ResultStatus resultStatus = tryMove();
            if (!resultStatus.isContinue()) {
                return getRetryStatus(resultStatus);
            }
            outputView.printMap(bridgeGame.findGameResult());
        }
    }

    private boolean getRetryStatus(final ResultStatus resultStatus) {
        if (resultStatus.isSuccess()) {
            return false;
        }
        outputView.printMap(bridgeGame.findGameResult());
        return checkRetry();
    }

    private boolean checkRetry() {
        outputView.printRetryRequest();
        final RetryCommand retryCommand = inputProvider.retryCommand();
        return retryCommand.isRetry();
    }

    private ResultStatus tryMove() {
        outputView.printMovingRequest();
        final BridgeType bridgeType = inputProvider.moveCommand();
        return bridgeGame.move(bridgeType);
    }

    private void makeBridge() {
        outputView.printBridgeSizeRequest();
        final int bridgeSize = inputProvider.bridgeSize();
        bridgeGame.makeBridge(bridgeSize);
    }
}
