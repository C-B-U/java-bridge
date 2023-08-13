package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final OutputView outputView = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

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
            outputView.printBridge(mapDrawing.draw(movingResult));
        } while (!stateChecker.isFinished(bridge, player));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
