package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<GameResultStatus> gameResultStatusList;

    public GameResult() {
        this.gameResultStatusList = new ArrayList<>();
    }

    public void addResultStatus(final GameResultStatus gameResultStatus) {
        this.gameResultStatusList.add(gameResultStatus);
    }
}
