package bridge;

import java.util.List;

import static bridge.SuccessFailure.*;

public class StateChecker {
    public SuccessFailure isSuccess(List<String> bridge, List<String> player) {
        if (bridge.equals(player))
            return SUCCESS;
        return FAILURE;
    }

    public boolean isFinished(List<String> bridge, List<String> player) {
        if (isAlive(bridge, player) && (player.size() < bridge.size()))
            return false;

        return !isAlive(bridge, player) || player.size() == bridge.size();
    }

    public boolean isAlive(List<String> bridge, List<String> player) {
        int nowIdx = player.size() - 1;
        String nowBridge = bridge.get(nowIdx);
        String nowPlayer = player.get(nowIdx);
        return nowPlayer.equals(nowBridge);
    }
}