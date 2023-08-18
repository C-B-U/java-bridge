package bridge;

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
            if (inputManager.isClearMoveBridge(bridgeGame, gameResultManager)){
                gameResultManager.printGameResult();
                break;
            }
            isProceed = inputManager.isRetryGame(bridgeGame, gameResultManager);
        }
    }

}
