package bridge.model;

public class GameStatus {

    private int position;
    private int retry;
    private GameResult gameResult;
    private static final int START_POSITION = 0;
    private static final int INIT_RETRY_COUNT = 1;

    private enum GameResult {
        GAME_SUCCESS("성공"),
        GAME_FAILED("실패");

        private final String result;

        GameResult(String result) {
            this.result = result;
        }
    }

    public GameStatus() {
        this.position = START_POSITION;
        this.retry = INIT_RETRY_COUNT;
        this.gameResult = GameResult.GAME_SUCCESS;
    }

    public void movePosition() {
        position++;
    }

    public void increaseRetryCount() {
        retry++;
    }

    public int getRetry() {
        return retry;
    }

    public int getPosition() {
        return position;
    }

    public void clear() {
        position = START_POSITION;
    }

    public void setGameResultFailed() {
        gameResult = GameResult.GAME_FAILED;
    }

    public String getGameResult() {
        return gameResult.result;
    }
}
