package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private final InputManager inputManager;

    public BridgeGameController() {
        this.inputManager = new InputManager();
    }

    public void gameStart(){
        BridgeGame bridgeGame = new BridgeGame(inputManager.makeBridge());
        inputManager.moveBridge(bridgeGame);
    }
}
