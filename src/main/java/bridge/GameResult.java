package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private static final String START_TAG = "[ ";
    private static final String END_TAG = " ]";
    private static final String SEPARATOR = " | ";
    private final List<GameResultStatus> gameResultStatusList;

    public GameResult() {
        this.gameResultStatusList = new ArrayList<>();
    }

    public void addResultStatus(final GameResultStatus gameResultStatus) {
        this.gameResultStatusList.add(gameResultStatus);
    }

    @Override
    public String toString() {
        return START_TAG + gameResultStatusList.stream()
                .map(GameResultStatus::toString)
                .collect(Collectors.joining(SEPARATOR)) + END_TAG;
    }
}
