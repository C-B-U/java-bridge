package bridge.manager;

import bridge.constant.MoveResult;
import bridge.domain.BridgeGame;
import bridge.domain.TryCount;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.factory.BridgeMaker;

public class BridgeGameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameManager(final InputView inputView, final OutputView outputView, final BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void playBridgeGame() {
        outputView.printGameStart();
        try {
            playUntilGameEnd();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void playUntilGameEnd() {
        boolean isGameRunning = true;
        final TryCount tryCount = new TryCount();
        final BridgeGame bridgeGame = makeBridgeGameWithSize();
        while (isGameRunning) {
            isGameRunning = moveAndGetRetryStatus(bridgeGame);
            if (isGameRunning) {
                tryCount.increment();
            }
        }
        outputView.printResult(tryCount, bridgeGame.getGameResultMap());
    }

    private BridgeGame makeBridgeGameWithSize() {
        outputView.printBridgeSizeRequest();
        final int bridgeSize = inputView.readBridgeSize();
        return new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
    }

    private boolean moveAndGetRetryStatus(final BridgeGame bridgeGame) {
        while (true) {
            final MoveResult moveResult = tryMove(bridgeGame);
            if (moveResult != MoveResult.CONTINUE) {
                return getRetryStatus(bridgeGame, moveResult);
            }
            outputView.printMap(bridgeGame.getGameResultMap());
        }
    }

    private MoveResult tryMove(final BridgeGame bridgeGame) {
        outputView.printMovingRequest();
        final String movingInput = inputView.readMoving();
        return bridgeGame.move(movingInput);
    }

    private boolean getRetryStatus(final BridgeGame bridgeGame, final MoveResult moveResult) {
        if (moveResult == MoveResult.SUCCESS) {
            return false;
        }
        outputView.printMap(bridgeGame.getGameResultMap());
        return checkRetry(bridgeGame);
    }

    private boolean checkRetry(final BridgeGame bridgeGame) {
        outputView.printRetryRequest();
        final String retryInput = inputView.readGameCommand();
        return bridgeGame.retry(retryInput);
    }
}
