package bridge.controller;

import bridge.model.BridgeGame;
import bridge.constant.GameProgressMessage;

public class BridgeGameController {

    private final InputManager inputManager;
    private final GameResultManager gameResultManager;
    public BridgeGameController() {
        this.inputManager = new InputManager();
        this.gameResultManager = new GameResultManager();
    }

    public void gameStart(){
        System.out.println(GameProgressMessage.START_BRIDGE_GAME);
        BridgeGame bridgeGame = new BridgeGame(inputManager.makeBridge());
        boolean isProceed = true;
        while (isProceed) {
            gameResultManager.upAttemptCount();
            if (inputManager.isSuccessMoveStage(bridgeGame,gameResultManager)){
                break;
            }
            isProceed = inputManager.isRetryGame(bridgeGame, gameResultManager);
        }
    }

}
