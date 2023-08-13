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
    private final AnswerTable answerTable = new AnswerTable();
    private final GameStatus gameStatus = new GameStatus();

    public BridgeController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        try {
            Bridge bridge = makeBridge();
            progressGame(bridge);
            printResult();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
        }
    }

    private Bridge makeBridge() {
        outputView.printGameStart();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    private void progressGame(Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge, gameStatus, answerTable);
        while (gameStatus.getPosition() < bridge.size()) {
            boolean isCorrect = bridgeGame.move(inputView.readMoving());
            outputView.printMap(answerTable);
            if(!isCorrect && !retry(bridgeGame)) {
                gameStatus.setGameResultFailed();
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

    private void printResult() {
        outputView.printResult(answerTable, gameStatus);
    }
}
