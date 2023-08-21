package bridge.model;

import bridge.constant.GameCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final BridgeStatus bridgeStatus;

    public BridgeGame(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
        this.bridgeStatus = new BridgeStatus();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeStatus move(String bridgeMoveStep, int stage) {
        if(isMoveBridge(bridgeMoveStep, stage)){
            bridgeStatus.successStair(bridgeMoveStep);
            return bridgeStatus;
        }
        bridgeStatus.failStair(bridgeMoveStep);
        return bridgeStatus;
    }

    public boolean isMoveBridge(String bridgeMoveStep, int stage){
        String floor = bridge.get(stage);
        return floor.equals(bridgeMoveStep);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public BridgeStatus retry(String command) {
        if(command.equals(GameCommand.RETRY.getCommand())){
            bridgeStatus.reset();
            return bridgeStatus;
        }
        bridgeStatus.stopNextStage();
        return bridgeStatus;
    }

    public int stages(){
        return bridge.size();
    }

}
