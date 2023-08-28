package bridge.domain;

import java.util.List;

public class GameState {
    public boolean isSuccess(List<String> bridge, List<String> player) {
        return bridge.equals(player);
    }

    public boolean isFinished(List<String> bridge, List<String> player) {
        return bridge.size() == player.size();
    }

    public boolean isAlive(List<String> bridge, int position, String playerMoving) {
        return bridge.get(position).equals(playerMoving);
    }
}
