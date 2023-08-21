package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printGameStart();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        outputView.printLengthMessage();
        bridgeMaker.makeBridge(inputView.readBridgeSize());

        outputView.printMovingDirectionMessage();
        inputView.readMoving();



    }
}