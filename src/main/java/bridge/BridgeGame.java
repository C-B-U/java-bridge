package bridge;

import bridge.constant.BridgeType;
import bridge.constant.ResultStatus;
import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.storage.BridgeStorage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeStorage bridgeStorage;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(final BridgeStorage bridgeStorage, final BridgeMaker bridgeMaker) {
        this.bridgeStorage = bridgeStorage;
        this.bridgeMaker = bridgeMaker;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public ResultStatus move(final BridgeType bridgeType) {
        final Bridge bridge = bridgeStorage.findBridge();
        final GameResult gameResult = bridgeStorage.findGameResult();

        return gameResult.addResultStatus(bridge, bridgeType);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeStorage.findGameResult().clearAndAddCount();
        bridgeStorage.findBridge().clearIndex();
    }

    public void makeBridge(final int bridgeSize) {
        final Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        bridgeStorage.saveBridge(bridge);
        bridgeStorage.saveGameResult(new GameResult());
    }

    public GameResult findGameResult() {
        return bridgeStorage.findGameResult();
    }
}
