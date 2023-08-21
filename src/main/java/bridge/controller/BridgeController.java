package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private BridgeGame bridgeGame;

    public void start() {
        try {
            bridgeGame = startGame();
            while (bridgeGame.isNotEnd()) {
                progress();
                if (bridgeGame.isFailed()) {
                    outputView.printRetryMessage();
                    bridgeGame.retry(inputView.readGameCommand());
                }
            }
            outputView.printResult(bridgeGame.getBridgeMaps(), bridgeGame.getGameRecorder());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private BridgeGame startGame() {
        outputView.printGameStart();
        outputView.printLengthMessage();
        return new BridgeGame(inputView.readBridgeSize());
    }

    private void progress() {
        while (bridgeGame.isProgress()) {
            outputView.printMovingDirectionMessage();
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeMaps());
        }
    }
}