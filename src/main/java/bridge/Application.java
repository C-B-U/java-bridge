package bridge;

import bridge.controller.BridgeController;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeController bridgeController = new BridgeController(new OutputView());
        bridgeController.start();
    }
}
