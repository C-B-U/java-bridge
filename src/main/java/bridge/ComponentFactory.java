package bridge;

public class ComponentFactory {

    public BridgeGameManager bridgeGameManager() {
        return new BridgeGameManager(inputView(), outputView());
    }

    private OutputView outputView() {
        return new OutputView();
    }

    private InputView inputView() {
        return new InputView(inputValidator());
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }
}
