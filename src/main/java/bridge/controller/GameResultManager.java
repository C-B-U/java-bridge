package bridge.controller;

public class GameResultManager {

    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";
    private int attemptCount = 0;
    private String gameClear = GAME_SUCCESS;


    public void upAttemptCount(){
        attemptCount++;
    }

    public void gameClearFail(){
        gameClear = GAME_FAIL;
    }

    public String getGameClear() {
        return gameClear;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
