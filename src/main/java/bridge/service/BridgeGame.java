package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.RetryCommand;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaps;
import bridge.domain.GameRecorder;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private final GameRecorder gameRecorder;
    private final BridgeMaps bridgeMaps = new BridgeMaps();

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
        gameRecorder = new GameRecorder(size);
        System.out.println(bridge.getBridge());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        boolean isCorrect = bridge.isCorrectMoving(moving, gameRecorder.getPosition());
        gameRecorder.movePosition();
        gameRecorder.checkProgress(isCorrect);
        bridgeMaps.addResult(moving, isCorrect);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(RetryCommand restartCommand) {
        gameRecorder.checkGameStatus(restartCommand);
        bridgeMaps.clear(restartCommand);
    }

    public boolean isProgress() {
        return gameRecorder.isProgress();
    }

    public boolean isNotEnd() {
        return gameRecorder.isNotEnd();
    }

    public boolean isFailed() {
        return gameRecorder.isFailed();
    }

    public BridgeMaps getBridgeMaps() {
        return bridgeMaps;
    }

    public GameRecorder getGameRecorder() {
        return gameRecorder;
    }
}
