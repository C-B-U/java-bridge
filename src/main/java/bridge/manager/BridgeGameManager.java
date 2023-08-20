package bridge.manager;

import bridge.BridgeGame;
import bridge.io.OutputView;
import bridge.io.InputManager;

public class BridgeGameManager {
    private final InputManager inputManager;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameManager(final InputManager inputManager, final OutputView outputView, final BridgeGame bridgeGame) {
        this.inputManager = inputManager;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void play() {

    }
}
