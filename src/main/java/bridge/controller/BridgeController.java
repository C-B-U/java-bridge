package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.AnswerTable;
import bridge.model.Bridge;
import bridge.model.Constant;
import bridge.model.GameStatus;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final OutputView outputView;
    private final InputView inputView;

    public BridgeController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printGameStart();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        AnswerTable answerTable = new AnswerTable();
        GameStatus gameStatus = new GameStatus();
        BridgeGame bridgeGame = new BridgeGame(bridge, gameStatus, answerTable);
        startGame(bridgeGame, gameStatus, bridge);
    }

    private void startGame(BridgeGame bridgeGame, GameStatus gameStatus, Bridge bridge) {
        while (gameStatus.getPosition() < bridge.size()) {
            boolean isCorrect = bridgeGame.move(inputView.readMoving());
            if(!isCorrect && !retry(bridgeGame)) {
                break;
            }
        }
    }

    private boolean retry(BridgeGame bridgeGame) {
        String userInput = inputView.readGameCommand();
        if (userInput.equals(Constant.RETRY.toString())) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
