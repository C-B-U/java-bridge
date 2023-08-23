package bridge;

public class BridgeStageRecord {

    private static final int firstStage = 0;
    private static int curStage = firstStage;

    public static int getCurStage() {
        return curStage;
    }

    public static void nextStage(){
        curStage++;
    }

    public static void reset(){
        curStage = firstStage;
    }

}
