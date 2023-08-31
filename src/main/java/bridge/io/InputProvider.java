package bridge.io;

import bridge.constant.BridgeType;

public class InputProvider {
    private final InputView inputView;

    public InputProvider(final InputView inputView) {
        this.inputView = inputView;
    }

    public int bridgeSize() {
        while (true) {
            try {
                return Integer.parseInt(inputView.readBridgeSize());
            } catch (final IllegalArgumentException ignored) {}
        }
    }

    public BridgeType moveCommand() {
        while (true) {
            try {
                return BridgeType.valueOf(inputView.readMoving());
            } catch (final IllegalArgumentException ignored) {}
        }
    }
}
