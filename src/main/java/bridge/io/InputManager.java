package bridge.io;

public class InputManager {
    private final InputView inputView;

    public InputManager(final InputView inputView) {
        this.inputView = inputView;
    }

    public int bridgeSize() {
        return inputView.readBridgeSize();
    }
}
