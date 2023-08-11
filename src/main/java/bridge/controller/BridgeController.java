package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.AnswerTable;
import bridge.model.Bridge;
import bridge.model.Player;
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
        Player player = new Player();
        BridgeGame bridgeGame = new BridgeGame(bridge, player, answerTable);
        boolean b = bridgeGame.move(inputView.readMoving());
    }
}
