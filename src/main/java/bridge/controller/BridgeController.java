package bridge.controller;

import bridge.domain.BridgeSize;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private BridgeGame bridgeGame;

    public void start() {
        bridgeGame = startGame();
        playGame();
        printGameResult();
    }

    private BridgeGame startGame() {
        outputView.printGameStart();
        BridgeSize bridgeSize = inputView.readBridgeSize();
        return new BridgeGame(bridgeSize);
    }

    private void playGame() {
        while (bridgeGame.isNotEnd()) {
            progress();
            handleFailed();
        }
    }

    private void progress() {
        while (bridgeGame.isProgress()) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeMaps());
        }
    }

    private void handleFailed() {
        if (bridgeGame.isFailed()) {
            bridgeGame.retry(inputView.readGameCommand());
        }
    }

    private void printGameResult() {
        outputView.printEndMessage();
        outputView.printMap(bridgeGame.getBridgeMaps());
        outputView.printResult(bridgeGame.getGameRecorder(), bridgeGame.getRetryCount());
    }
}