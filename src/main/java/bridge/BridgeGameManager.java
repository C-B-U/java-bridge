package bridge;

public class BridgeGameManager {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameManager(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playBridgeGame() {
        outputView.printGameStart();
        playUntilGameEnd();
    }

    private void playUntilGameEnd() {
        boolean gameRunning = true;
        while (gameRunning) {
            outputView.printBridgeLengthRequest();
            final int bridgeLength = inputView.readBridgeSize();
        }
    }
}
