package bridge.controller;

import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printGameStart();

        outputView.printLengthMessage();
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());

        outputView.printMovingDirectionMessage();
        bridgeGame.move(inputView.readMoving());
    }
}