package bridge.io;

public class InputManager {
    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputManager(final InputView inputView, final InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }
}
