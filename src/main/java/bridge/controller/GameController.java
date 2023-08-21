package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final AttemptCount attemptCount = new AttemptCount();
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController (InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void setGame() {
        outputView.printGameStartMessage();
        outputView.printBridgeSizeInputMessage();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        processGame();
    }

    public void processGame() {
        boolean process;
        do {
            outputView.printSelectMovingMessage();
            process = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.drawMap());
        } while (process);
        if (bridgeGame.isSuccess()) {
            quitGame();
            return;
        }
        retryGame();
    }

    private void retryGame() {
        outputView.printRetryOrEndGameMessage();
        String command = inputView.readGameCommand();
        if (command.equals(Keyword.RETRY.getKey())) {
            bridgeGame.retry();
            attemptCount.increaseCount();
            processGame();
        }
    }
}
