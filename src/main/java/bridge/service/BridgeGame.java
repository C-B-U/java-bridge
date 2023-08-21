package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeMap;
import bridge.domain.GameState;
import bridge.domain.PlayerPosition;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private final GameState gameState = new GameState();
    private List<String> player = new ArrayList<>();
    private BridgeMap bridgeMap = new BridgeMap();
    private PlayerPosition playerPosition = new PlayerPosition();

    public BridgeGame(List<String> bridge) {
        this.bridge = new Bridge(bridge);
        System.out.println(this.bridge.getBridge());
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

    public boolean isSuccess() {
        return gameState.isSuccess(bridge.getBridge(),player);
    }

    public void retry() {
        bridgeMap = new BridgeMap();
        playerPosition = new PlayerPosition();
        player = new ArrayList<>();
    }
}
