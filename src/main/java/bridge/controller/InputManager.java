package bridge.controller;

import bridge.*;
import bridge.io.view.InputView;
import bridge.io.view.OutputView;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeStatus;

import java.util.List;

public class InputManager {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private final OutputView outputView;

    public InputManager() {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.outputView = new OutputView();
    }

    public List<String> makeBridge(){
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean isSuccessMoveStage(BridgeGame bridgeGame, GameResultManager gameResultManager) {
        BridgeStatus bridgeStatus = null;
        for (int stage = 0; stage < bridgeGame.stages(); stage++){
            String bridgeMoveStep = inputView.readMoving();
            bridgeStatus = bridgeGame.move(bridgeMoveStep, stage);
            outputView.printMap(bridgeStatus);
            if (!bridgeStatus.isNextStage()){
                return false;
            }
        }
        outputView.printResult(bridgeStatus, gameResultManager);
        return true;

    }

    public boolean isRetryGame(BridgeGame bridgeGame, GameResultManager gameResultManager){
        String command = inputView.readGameCommand();
        BridgeStatus bridgeStatus = bridgeGame.retry(command);
        if(bridgeStatus.isNextStage()){
            return true;
        }
        gameResultManager.gameClearFail();
        outputView.printResult(bridgeStatus ,gameResultManager);
        return false;
    }

}
