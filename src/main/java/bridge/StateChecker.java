package bridge;

import java.util.List;

import static bridge.SuccessFailure.*;

public class StateChecker {
    public boolean isAlive(List<String> bridge, List<String> player) {
        int nowIdx = player.size() - 1;
        String nowBridge = bridge.get(nowIdx);
        String nowPlayer = player.get(nowIdx);
        return nowPlayer.equals(nowBridge);
    }
}