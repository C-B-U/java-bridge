package bridge.controller;

import bridge.*;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void startGame(){
        makeGame();
        progressGame();
    }

    private void makeGame() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.makeBridge(bridgeSize);
    }

    private void progressGame() {
        while (BridgeStageRecord.isProgressing()){
            String stage = inputView.readMoving();
            bridgeGame.move(stage);
            outputView.printMap(bridgeGame.getBridgeMap());
            ifFailStageThenRetryGameOrQuit();
        }
        outputView.printResult(bridgeGame.getBridgeMap());
    }

    private void ifFailStageThenRetryGameOrQuit(){
        if (BridgeStageRecord.canNotMoveNextStage()){
            bridgeGame.retry(inputView.readGameCommand());
        }
    }
}
