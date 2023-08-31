package bridge.io;

import bridge.constant.BridgeType;
import bridge.constant.RetryCommand;

import java.util.function.Supplier;

public class InputProvider {
    private final InputView inputView;

    public InputProvider(final InputView inputView) {
        this.inputView = inputView;
    }

    public int bridgeSize() {
        return read(() -> Integer.parseInt(inputView.readBridgeSize()));
    }

    public BridgeType moveCommand() {
        return read(() -> BridgeType.valueOf(inputView.readMoving()));
    }

    public RetryCommand retryCommand() {
        return read(() -> RetryCommand.valueOf(inputView.readGameCommand()));
    }

    private <T> T read(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (final IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
