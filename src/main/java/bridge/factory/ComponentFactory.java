package bridge.factory;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.io.InputProvider;
import bridge.io.InputValidator;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.manager.BridgeGameManager;
import bridge.manager.ResultManager;

public class ComponentFactory {

    public BridgeGameManager bridgeGameManager() {
        return new BridgeGameManager(inputProvider(), outputView(), bridgeGame());
    }

    private BridgeGame bridgeGame() {
        return new BridgeGame(resultManager(), bridgeMaker());
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

    private ResultManager resultManager() {
        return new ResultManager();
    }

    private BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
