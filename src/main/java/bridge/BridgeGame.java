package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String LINE_DELIMETER = "\n";
    private final GameResult upperGameResult;
    private final GameResult lowerGameResult;
    private final Bridge bridge;
    private Integer currentIndex;

    public BridgeGame(final List<String> bridgeDirections) {
        this.bridge = new Bridge(bridgeDirections);
        this.upperGameResult = new GameResult();
        this.lowerGameResult = new GameResult();
        initCurrentIndex();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(final String movingInput) {
        final BridgeType inputBridgeType = BridgeType.valueOf(movingInput);
        final BridgeType answerBridgeType = bridge.getNextElement(currentIndex++);

        final MoveResultMapper moveResultMapper = MoveResultMapper.getInstance();
        final MoveResult moveResult = moveResultMapper.mapToMoveResult(inputBridgeType, answerBridgeType, bridge.getLeftSize());
        addGameResultStatus(moveResult, answerBridgeType);
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        return true;
    }

    private void addGameResultStatus(final MoveResult moveResult, final BridgeType answerBridgeType) {
        if (moveResult.isFailed()) {
            addToValidGameResult(answerBridgeType, GameResultStatus.X);
            return;
        }
        addToValidGameResult(answerBridgeType, GameResultStatus.O);
    }

    private void addToValidGameResult(final BridgeType answerBridgeType, final GameResultStatus gameResultStatus) {
        if (answerBridgeType.equals(BridgeType.U)) {
            upperGameResult.addResultStatus(gameResultStatus);
            lowerGameResult.addResultStatus(GameResultStatus.NONE);
            return;
        }
        upperGameResult.addResultStatus(GameResultStatus.NONE);
        lowerGameResult.addResultStatus(gameResultStatus);
    }

    public String getGameResultMap() {
        return this.upperGameResult + LINE_DELIMETER + this.lowerGameResult;
    }

    private void initCurrentIndex() {
        this.currentIndex = 0;
    }
}
