package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.Player;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final OutputView outputView;
    private final InputView inputView;

    public BridgeController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printGameStart();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        BridgeGame bridgeGame = new BridgeGame(bridge, new Player());
        boolean b = bridgeGame.move(inputView.readMoving());
    }
}
