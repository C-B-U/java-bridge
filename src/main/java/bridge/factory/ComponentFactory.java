package bridge.factory;

import bridge.service.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.io.InputProvider;
import bridge.io.InputValidator;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.manager.BridgeGameManager;
import bridge.storage.BridgeStorage;

public class ComponentFactory {

    public BridgeGameManager bridgeGameManager() {
        return new BridgeGameManager(inputProvider(), outputView(), bridgeGame());
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame(bridgeStorage(), bridgeMaker());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputProvider inputProvider() {
        return new InputProvider(inputView());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private BridgeStorage bridgeStorage() {
        return new BridgeStorage();
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
