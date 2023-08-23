package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {
    private static final int DEFAULT_STAGE_NUM = 1;
    private final List<String> bridge;
    public Bridge(List<String> bridge) {
        this.bridge = new ArrayList<>(bridge);
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int stages(){
        return bridge.size();
    }

    public boolean isStageStatus(String bridgeStage, int curStage){
        return bridge.get(curStage).equals(bridgeStage);
    }

    public boolean clearGame(int curStage) {
        return stages() == curStage+DEFAULT_STAGE_NUM;
    }
}
