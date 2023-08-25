package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final boolean CLEARS_GAME = true;
    private final BridgeMaker bridgeMaker;
    private final BridgeMap bridgeMap;
    private Bridge bridge;

    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeMap = new BridgeMap();
    }

    public void makeBridge(int bridge){
        this.bridge = new Bridge(bridgeMaker.makeBridge(bridge));
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String bridgeStageCommand) {
        int curStage = BridgeStageRecord.getCurStage();
        boolean canMoveStage = bridge.canMoveStage(bridgeStageCommand, curStage);
        bridgeMap.moveStair(bridgeStageCommand, canMoveStage);
        checksStageStatus(canMoveStage);
        BridgeStageRecord.nextStage();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void checksStageStatus(boolean canMoveStage){
        if (bridge.clearsAllStage(BridgeStageRecord.getCurStage())) {
            BridgeStageRecord.changeProgressStatus(CLEARS_GAME);
        }
        BridgeStageRecord.changeMoveStatus(canMoveStage);
    }

    public BridgeMap getBridgeMap() {
        return bridgeMap;
    }
}
