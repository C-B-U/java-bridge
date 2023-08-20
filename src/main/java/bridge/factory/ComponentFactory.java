package bridge.factory;

import bridge.BridgeGame;
import bridge.io.InputManager;
import bridge.io.InputValidator;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.manager.BridgeGameManager;

public class ComponentFactory {

    public BridgeGameManager bridgeGameManager() {
        return new BridgeGameManager(inputManager(), outputView(), bridgeGame());
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputManager inputManager() {
        return new InputManager(inputView(), inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private InputView inputView() {
        return new InputView();
    }
}
