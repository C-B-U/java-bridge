package bridge;

import java.util.List;

public class BridgeGameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameManager(final InputView inputView, final OutputView outputView, final BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void playBridgeGame() {
        outputView.printGameStart();
        playUntilGameEnd();
    }

    private void playUntilGameEnd() {
        boolean isGameRunning = true;
        while (isGameRunning) {
            outputView.printBridgeLengthRequest();
            final int bridgeLength = inputView.readBridgeSize();
            final List<String> bridgeDirections = bridgeMaker.makeBridge(bridgeLength);
        }
    }
}
