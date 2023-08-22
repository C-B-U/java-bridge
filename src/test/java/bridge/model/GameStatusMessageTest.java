package bridge.model;

import bridge.constant.GameStatus;
import bridge.constant.RetryCommand;
import bridge.domain.Bridge;
import bridge.domain.BridgeSize;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameStatusMessageTest {

    @Test
    void checkRetryStatus() {
        RetryCommand retryCommand = RetryCommand.QUIT;

        GameStatus gameStatus = GameStatus.checkStatus(retryCommand);

        assertThat(gameStatus).isEqualTo(GameStatus.GAME_QUIT);
    }

    @Test
    void checkClearStatus() {
        int position = 3;
        BridgeSize bridgeSize = new BridgeSize(3);
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        boolean isCorrect = bridge.isCorrectMoving("D", 2);

        GameStatus gameStatus = GameStatus.checkStatus(isCorrect, bridgeSize, position);

        assertThat(gameStatus).isEqualTo(GameStatus.GAME_SUCCESS);
    }

    @Test
    void checkMovingFailedStatus() {
        int position = 3;
        BridgeSize bridgeSize = new BridgeSize(3);
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        boolean isCorrect = bridge.isCorrectMoving("U", 2);

        GameStatus gameStatus = GameStatus.checkStatus(isCorrect, bridgeSize, position);

        assertThat(gameStatus).isEqualTo(GameStatus.MOVING_FAILED);
    }
}
