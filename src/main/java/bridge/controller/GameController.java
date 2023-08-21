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
}
