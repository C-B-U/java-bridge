package bridge.factory;

import bridge.manager.BridgeGameManager;

public class ComponentFactory {

    public BridgeGameManager bridgeGameManager() {
        return new BridgeGameManager();
    }
}
