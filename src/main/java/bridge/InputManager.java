package bridge;

import java.util.List;

public class InputManager {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public InputManager() {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> makeBridge(){
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean isClearMoveBridge(BridgeGame bridgeGame, GameResultManager gameResultManager){
        for (int gameStage = 0; gameStage < bridgeGame.stages(); gameStage++){
            String bridgeMoveStep = inputView.readMoving();
            boolean isProceed = bridgeGame.move(bridgeMoveStep, gameStage);
            if (!isProceed){
                gameResultManager.printFailBridge(bridgeMoveStep);
                return false;
            }
            gameResultManager.printSuccessBridge(bridgeMoveStep);
        }
        return true;
    }

    public boolean isRetryGame(BridgeGame bridgeGame, GameResultManager gameResultManager){
        String command = inputView.readGameCommand();
        if(bridgeGame.retry(command)){
            gameResultManager.restartGameSet();
            return true;
        }
        gameResultManager.gameClearFail();
        gameResultManager.printGameResult();
        return false;
    }




}
