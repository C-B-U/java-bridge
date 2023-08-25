package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController(
                new InputView(), new OutputView(), new BridgeGame());
        bridgeGameController.startGame();
    }
}
