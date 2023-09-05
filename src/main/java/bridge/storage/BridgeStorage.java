package bridge.storage;

import bridge.domain.Bridge;
import bridge.domain.GameResult;

public class BridgeStorage {
    private GameResult gameResult;
    private Bridge bridge;

    public void saveBridge(final Bridge bridge) {
        this.bridge = bridge;
    }

    public Bridge findBridge() {
        return this.bridge;
    }

    public void saveGameResult(final GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public GameResult findGameResult() {
        return this.gameResult;
    }
}
