package bridge;

public class BridgeStageRecord {

    private static final int firstStage = 0;
    private static int curStage = firstStage;
    private static boolean canMoveNextStage = true;
    private static boolean clearsGame = false;

    public static int getCurStage() {
        return curStage;
    }

    public static void nextStage(){
        curStage++;
    }

    public static void reset(){
        curStage = firstStage;
        canMoveNextStage = true;
    }

    public static void changeMoveStatus(boolean stageStatus){
        canMoveNextStage = stageStatus;
    }

    public static void changeProgressStatus(boolean stageStatus) {
        clearsGame = stageStatus;
    }

    public static boolean isProgressing(){
        return canMoveNextStage && !clearsGame;
    }

    public static boolean canNotMoveNextStage() {
        return !canMoveNextStage;
    }
}
