package bridge;

public class BridgeGameController {

    private final InputManager inputManager;
    private final GameResult gameResult;

    public BridgeGameController() {
        this.inputManager = new InputManager();
        this.gameResult = new GameResult();
    }

    public void gameStart(){
        BridgeGame bridgeGame = new BridgeGame(inputManager.makeBridge());
        boolean isProceed = true;
        while (isProceed){
            gameResult.upAttemptCount();
            if(inputManager.isClearMoveBridge(bridgeGame, gameResult)){
                gameResult.printGameResult();
                break;
            }
            isProceed = isRetryGame(bridgeGame);
        }
    }

    private boolean isRetryGame(BridgeGame bridgeGame) {
        boolean isRetryGame = inputManager.isRetryGame(bridgeGame);
        if(isRetryGame){
            gameResult.restartGameSet();
            return true;
        }
        gameResult.gameClearFail();
        gameResult.printGameResult();
        return false;
    }
}
