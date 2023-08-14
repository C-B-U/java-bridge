package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Keyword.RETRY;
import static bridge.SuccessFailure.FAILURE;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final StateChecker stateChecker = new StateChecker();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeDrawing bridgeDrawing = new BridgeDrawing();
    private List<String> player = new ArrayList<>();
    private List<String> bridge;
    private int attempt = 1;

    public void start() {
        try {
            outputView.printGameStartMessage();
            bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
            move();
        } catch (IllegalArgumentException error) {
            outputView.printErrorMessage(error);
        }
    }

    public void move() {
        MovingResult movingResult;
        do {
            String direction = inputView.readMoving();
            player.add(direction);
            movingResult = new MovingResult(direction, stateChecker.isAlive(bridge, player));
            outputView.printBridge(bridgeDrawing.draw(movingResult));
        } while (!stateChecker.isFinished(bridge, player));
        judge();
    }

    private boolean judge() {
        if (stateChecker.isSuccess(bridge, player) == FAILURE && retry()) {
            attempt += 1;
            move();
            return true;
        }
        outputView.printFinalResult(bridgeDrawing.getResultBridge(), stateChecker.isSuccess(bridge, player), attempt);
        return false;
    }

    public boolean retry() {
        String command = inputView.readGameCommand();
        if (command.equals(RETRY.getKey())) {
            player = new ArrayList<>();
            bridgeDrawing = new BridgeDrawing();
            return true;
        }
        return false;
    }
}
