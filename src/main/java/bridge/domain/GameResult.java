package bridge.domain;

import bridge.constant.BridgeType;
import bridge.constant.ResultStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String LINE_DELIMITER = "\n";
    private static final String START_TAG = "[ ";
    private static final String END_TAG = " ]";
    private static final String SEPARATOR = " | ";
    private final List<ResultStatus> upperResult;
    private final List<ResultStatus> lowerResult;
    private final TryCount tryCount;

    public GameResult() {
        this.upperResult = new ArrayList<>();
        this.lowerResult = new ArrayList<>();
        this.tryCount = new TryCount();
    }

    public ResultStatus addResultStatus(final Bridge bridge, final BridgeType input) {
        final BridgeType answer = bridge.getCurrentElement();
        final ResultStatus resultStatus = bridge.compareToInput(input, answer);

        classifyResultStatus(answer, resultStatus);
        return resultStatus;
    }

    private void classifyResultStatus(final BridgeType answer, final ResultStatus resultStatus) {
        if (resultStatus.isCorrect()) {
            addByAnswerCase(answer, resultStatus, ResultStatus.NONE);
            return;
        }
        addByAnswerCase(answer, ResultStatus.NONE, resultStatus);
    }

    private void addByAnswerCase(final BridgeType answer, final ResultStatus resultStatus, final ResultStatus oppositeStatus) {
        if (answer.isUp()) {
            upperResult.add(resultStatus);
            lowerResult.add(oppositeStatus);
            return;
        }
        upperResult.add(oppositeStatus);
        lowerResult.add(resultStatus);
    }

    @Override
    public String toString() {
        return toLineString(upperResult)
                + LINE_DELIMITER
                + toLineString(lowerResult);
    }

    private String toLineString(final List<ResultStatus> line) {
        return START_TAG + line.stream()
                .map(ResultStatus::toString)
                .collect(Collectors.joining(SEPARATOR))
                + END_TAG;
    }
}
