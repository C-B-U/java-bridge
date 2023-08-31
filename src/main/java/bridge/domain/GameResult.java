package bridge.domain;

import bridge.constant.ResultStatus;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
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
}
