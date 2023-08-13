package bridge;

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
        playUntilGameEnd();
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
        outputView.printResult(tryCount);
    }

    private boolean moveAndGetRetryStatus(final BridgeGame bridgeGame) {
        boolean isContinue = true;
        while (isContinue) {
            final MoveResult moveResult = tryMove(bridgeGame);
            outputView.printMap(bridgeGame.getGameResultMap());
            if (moveResult.isFailed()) {
                return checkRetry(bridgeGame);
            }
            isContinue = moveResult.isContinue();
        }
        return false;
    }

    private boolean checkRetry(final BridgeGame bridgeGame) {
        outputView.printRetryRequest();
        final String retryInput = inputView.readGameCommand();
        return bridgeGame.retry(retryInput);
    }

    private BridgeGame makeBridgeGameWithSize() {
        outputView.printBridgeSizeRequest();
        final int bridgeSize = inputView.readBridgeSize();
        return new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
    }

    private MoveResult tryMove(final BridgeGame bridgeGame) {
        outputView.printMovingRequest();
        final String movingInput = inputView.readMoving();
        return bridgeGame.move(movingInput);
    }
}
