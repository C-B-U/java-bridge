package bridge.service;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final GameState gameState = new GameState();
    private List<String> player = new ArrayList<>();
    private BridgeMap bridgeMap = new BridgeMap();
    private PlayerPosition playerPosition = new PlayerPosition();

    public BridgeGame(List<String> bridge) {
        this.bridge = new Bridge(bridge);
        System.out.println(this.bridge.getBridge());
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    public boolean move(String moving) {
        playerPosition.moveNextPosition();
        player.add(moving);
        boolean isRightMoving = gameState.isAlive(bridge.getBridge(), playerPosition.getPosition(), moving);
        boolean isFinished = gameState.isFinished(bridge.getBridge(), player);
        bridgeMap.addMovingResult(moving, isRightMoving);
        return isRightMoving && !isFinished;
    }

    public String drawMap() {
        return bridgeMap.drawBridgeMap();
    }

    public void retry() {
    }
}
