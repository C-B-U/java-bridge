package bridge.controller;

import bridge.view.OutputView;

public class BridgeController {

    private final OutputView outputView;

    public BridgeController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        outputView.printGameStart();
    }
}
