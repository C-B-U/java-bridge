package bridge.domain;

import bridge.constant.BridgeType;
import bridge.constant.GameResultStatus;
import bridge.constant.MoveResult;
import bridge.constant.RetryCommand;
import bridge.factory.MoveResultMapper;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String LINE_DELIMITER = "\n";
    private static final int INITIAL_INDEX = 0;
    private final GameResult upperGameResult;
    private final GameResult lowerGameResult;
    private final MoveResultMapper moveResultMapper; // 요구사항에 의해 한 번만 생성될 것이므로 싱글톤으로 구현하지 않음
    private final Bridge bridge;
    private Integer currentIndex;

    public BridgeGame(final List<String> bridgeDirections) {
        this.bridge = new Bridge(bridgeDirections);
        this.upperGameResult = new GameResult();
        this.lowerGameResult = new GameResult();
        this.moveResultMapper = new MoveResultMapper();
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

        final MoveResult moveResult = moveResultMapper.mapToMoveResult(inputBridgeType, answerBridgeType, bridge.getLeftSize(currentIndex));
        addGameResultStatus(moveResult, answerBridgeType);
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(final String retryInput) {
        if (retryInput.equals(RetryCommand.R.toString())) {
            initCurrentIndex();
            upperGameResult.clearResult();
            lowerGameResult.clearResult();
            return true;
        }
        return false;
    }

    private void addGameResultStatus(final MoveResult moveResult, final BridgeType answerBridgeType) {
        if (moveResult == MoveResult.FAILED) {
            addToProperGameResult(answerBridgeType, GameResultStatus.X, false);
            return;
        }
        addToProperGameResult(answerBridgeType, GameResultStatus.O, true);
    }

    private void addToProperGameResult(final BridgeType answerBridgeType, final GameResultStatus gameResultStatus, final boolean isSuccess) {
        if (answerBridgeType.equals(BridgeType.U)) {
            addResultStatus(isSuccess, gameResultStatus, GameResultStatus.NONE);
            return;
        }
        addResultStatus(isSuccess, GameResultStatus.NONE, gameResultStatus);
    }

    private void addResultStatus(final boolean isSuccess, final GameResultStatus resultStatus, final GameResultStatus oppositeStatus) {
        if (isSuccess) {
            upperGameResult.addResultStatus(resultStatus);
            lowerGameResult.addResultStatus(oppositeStatus);
            return;
        }
        upperGameResult.addResultStatus(oppositeStatus);
        lowerGameResult.addResultStatus(resultStatus);
    }

    public String getGameResultMap() {
        return this.upperGameResult + LINE_DELIMITER + this.lowerGameResult;
    }

    private void initCurrentIndex() {
        this.currentIndex = INITIAL_INDEX;
    }
}
