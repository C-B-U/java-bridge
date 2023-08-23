package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Keyword;
import bridge.domain.AttemptCount;
import bridge.domain.BridgeMaker;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private AttemptCount attemptCount = new AttemptCount();

    public GameController (InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGame() {
        outputView.printGameStartMessage();
        outputView.printBridgeSizeInputMessage();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        processGame();
    }

    public void processGame() {
        boolean isFinished;
        do {
            outputView.printSelectMovingMessage();
            isFinished = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.drawMap());
        } while (isFinished);
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
        quitGame();
    }

    private void quitGame() {
        outputView.printQuitMessage();
        outputView.printMap(bridgeGame.drawMap());
        outputView.printResult(bridgeGame.isSuccess(), attemptCount.getCount());
    }
}
