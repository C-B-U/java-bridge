package bridge.io;

import bridge.constant.MoveCommand;

public class InputManager {
    private final InputView inputView;

    public InputManager(final InputView inputView) {
        this.inputView = inputView;
    }

    public int bridgeSize() {
        return inputView.readBridgeSize();
    }

    public MoveCommand moveCommand() {
        return MoveCommand.valueOf(inputView.readMoving());
    }
}
